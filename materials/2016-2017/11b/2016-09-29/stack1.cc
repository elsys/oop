#include <iostream>
#include <cstdlib>

#define STACK_SIZE 10

using namespace std;

class Stack {
    int content_[STACK_SIZE];
    int top_;
    
    public:
    
    Stack() {
        top_ = -1;
    }
    
    int push(int value) {
        if (top_ >= STACK_SIZE - 1) {
            cout << "The stack is full.." << endl;
            return -1;
        }
        content_[++top_] = value;    
        return 0;
    }
    
    int pop() {
        if (top_ > -1) {
            return content_[top_--];
        }
        cout << "The stack is empty.." << endl;
        return -1;
    }
};

int main() {
    Stack st;
    for (int i = -1; i < 9; i++) {
        if (st.push(i) == -1) {
            exit(1);
        }
    }
    
    //if (st.push(10) == -1) {
    //    return 1;
    //}
    
    for (int i = 0; i < 11; i++) {
        int value = st.pop();
        if (value == -1) {
            exit(1);
        } else {
            cout << value << endl;
        }
    }
    cout << st.pop() << endl;
    cout << st.pop() << endl;
    return 0;
}
