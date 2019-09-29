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
    try {
        for (int i= 0; i < 50; i++) {
            cout << st.pop() << endl;
        }
    } catch (StackError er) {
        cout << "Not able to pop..." << endl;
    }
    return 0;
}
