#include <iostream>
#include <cstring>

using namespace std;

class StackError {};

class Stack {
    int* data_;
    int capacity_, size_;
    const static int chunk_ = 10;
    
    void resize() {
        // 1. new memory
        capacity_ += chunk_;
        cout << "Resizing the stack to " << capacity_ << endl;
        int* new_data = new int[capacity_];
        // 2. copy data_ into new memory
        memcpy(new_data, data_, size_ * sizeof(int));
        // 3. delete old data_
        delete [] data_;
        // 4. data_ points to new data
        data_ = new_data;
    }
    
    public:
 
    Stack(int capacity = 10) {
        data_ = new int[capacity];
        capacity_ = capacity;
        size_ = 0;
    }
    
    Stack(const Stack& other) 
    : data_(new int[other.capacity_]),
    	capacity_(other.capacity_),
    	size_(other.size_)
    {
    	cout << "Stack(const Stack&) called..." << endl;
    	for(int i=0;i < other.size_; ++i) {
    		data_[i] = other.data_[i];
    	}
    }
    
    ~Stack() {
    	delete [] data_;
    }	
    
    bool empty() const {
    	return size_ == 0;
    }
    
    void push(int value) {
        cout << "Trying to push " << value << endl;
        if (size_ == capacity_) {
            resize();
        }
        data_[size_++] = value;
    }
    
    int pop() {
        if (size_ == 0) {
            throw StackError();
        }
        return data_[--size_];
    }
};

int main() {
    Stack st;
    for (int i = 0; i < 25; i++) {
        st.push(i);
    }
    Stack st2(st);
    
    try {
        for (int i= 0; i < 50; i++) {
            cout << st.pop() << endl;
        }
    } catch (StackError er) {
        cout << "Not able to pop..." << endl;
    }
    while(!st2.empty()) {
    	cout << st2.pop() << endl;
    }
    
    return 0;
}
