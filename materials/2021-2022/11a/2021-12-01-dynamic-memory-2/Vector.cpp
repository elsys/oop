#include "Vector.hh"
#include <stdexcept>

using namespace std;

Vector::Vector()
{
    size = 0;
    capacity = 2;
    data = new int[capacity];
}

Vector::~Vector()
{
    delete[] data;
    size = 0;
    capacity = 0;
}

Vector::Vector(const Vector &other)
{
    size = other.size;
    capacity = other.capacity;
    data = new int[capacity];
    for (int i = 0; i < size; i++)
    {
        data[i] = other.data[i];
    }
}

Vector &Vector::operator=(const Vector &other)
{
    if (this != &other)
    {
        delete[] data;
        size = other.size;
        capacity = other.capacity;
        data = new int[capacity];
        for (int i = 0; i < size; i++)
        {
            data[i] = other.data[i];
        }
    }

    return *this;
}

int Vector::get_size() const
{
    return size;
}

int Vector::get_capacity() const
{
    return capacity;
}

bool Vector::is_empty() const
{
    return size == 0;
}

void Vector::resize(int new_capacity)
{
    if (new_capacity < size)
    {
        throw invalid_argument("Can't change capacity to smaller than current size!");
    }

    capacity = new_capacity;
    int *temp = data;
    data = new int[capacity];
    for (int i = 0; i < size; i++)
    {
        data[i] = temp[i];
    }

    delete[] temp;
}

void Vector::reserve(int reserve_capacity)
{
    if (reserve_capacity > capacity)
    {
        resize(reserve_capacity);
    }
}

void Vector::shrink_to_fit()
{
    resize(size);
}

int Vector::at(int index) const
{
    if (index < 0 || index >= size)
    {
        throw range_error("Index out of bounds!");
    }

    return data[index];
}

int Vector::operator[](int index) const
{
    return at(index);
}

void Vector::push_back(int value)
{
    if (capacity <= size)
    {
        resize(capacity * 2);
    }

    data[size++] = value;
}

void Vector::pop_back()
{
    if (is_empty())
    {
        throw range_error("Vector is empty");
    }

    size--;
}

int Vector::front() const
{
    return at(0);
}

int Vector::back() const
{
    return at(size - 1);
}

Vector::iterator Vector::begin() const
{
    return iterator(this);
}

Vector::iterator Vector::end() const
{
    return iterator(this, size);
}

Vector::iterator::iterator(const Vector *vector)
{
    index = 0;
    this->vector = vector;
}

Vector::iterator::iterator(const Vector *vector, int index)
{
    this->vector = vector;
    this->index = index;
}

Vector::iterator &Vector::iterator::operator++(int)
{
    if (index < vector->size)
    {
        index++;
    }

    return *this;
}

Vector::iterator &Vector::iterator::operator--(int)
{
    if (index > 0)
    {
        index--;
    }

    return *this;
}

int Vector::iterator::operator*()
{
    return vector->at(index);
}

bool Vector::iterator::operator<(iterator other)
{
    return index < other.index;
}

bool Vector::iterator::operator<=(iterator other)
{
    return index <= other.index;
}

bool Vector::iterator::operator>(iterator other)
{
    return index > other.index;
}

bool Vector::iterator::operator>=(iterator other)
{
    return index > other.index;
}