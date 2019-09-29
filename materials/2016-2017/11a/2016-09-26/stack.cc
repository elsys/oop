#include <iostream>

#define STACK_SIZE 10

using namespace std;

class Stack {
    int content_[STACK_SIZE];
    int top_;
    
    public:
    
    Stack() {
        top_ = -1;
    }
    
    void push(int value) {
        if (top_ < STACK_SIZE - 1) {
            content_[++top_] = value;
        } else {
            cout << "The stack is full.." << endl;
        }
    }
    
    int pop() {
        if (top_ > -1) {
            return content_[top_--];
        }
        cout << "The stack is empty.." << endl;
        return 0;
    }
};

int main() {
    Stack st;
    for (int i = 0; i < 11; i++) {
        st.push(i);
    }
    st.push(10);
    cout << st.pop() << endl;
    cout << st.pop() << endl;
}
