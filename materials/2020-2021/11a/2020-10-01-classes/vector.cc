#include<iostream>
#include<stdlib.h>
using namespace std;
class Vector
{
    int size;
    int *arr;
public:
    Vector(){this->size = 0; this->arr=NULL;}
    void push(int element)
    {
        this->arr = (int*)realloc(this->arr, sizeof(int)*(this->size+1));
        this->arr[size++] = element;
    }
    int pop()
    {
        int last_element = this->arr[size-1];
        this->arr = (int*)realloc(this->arr, sizeof(int)*(this->size-1));
        this->size--;
        return last_element;
    }
    void printVector()
    {
        for(int i=0;i<this->size;++i)
        {
            std::cout<<this->arr[i]<<endl;
        }
    }
    int getSize()
    {
        return this->size;
    }

};
int main()
{
Vector v1;
v1.push(1);
v1.push(2);
v1.push(3);
v1.push(4);
v1.push(5);

v1.printVector();

while(v1.getSize()!= 0)
{
    cout<<v1.pop()<<endl;
}

}
