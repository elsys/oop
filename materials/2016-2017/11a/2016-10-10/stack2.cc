#include <iostream>
#include <list>

#define STACK_SIZE 10

using namespace std;

class StackError {
    int code_;
    
    public:
    
    StackError(int code) {
        code_ = code;
    }
    
    int get_code() {
        return code_;
    }
};

class Stack {
    list<int> content_;
    
    public:
    
    void push(int value) {
        content_.push_back(value);
    }
    
    int size() {
        return content_.size();
    }
    
    bool empty() {
        return content_.size() == 0;
    }
    
    int pop() {
        if (empty()) {
            throw StackError(-1);
        }
        int value = content_.back();
        content_.pop_back();
        return value;
    }
    
    void print() {
        for (list<int>::reverse_iterator it = content_.rbegin();
             it != content_.rend(); it++) {
            //...
        }
    }
};

int main() {
    Stack st;
    
    
}
