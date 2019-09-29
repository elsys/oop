#include <iostream>

#define STACK_SIZE 10

using namespace std;

class TooBigValueError {

};

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
    int content_[STACK_SIZE];
    int top_;
    
    public:
    
    Stack() {
        top_ = -1;
    }
    
    void push(int value) {
        if (value > 1000) {
            throw TooBigValueError();
        } else if (top_ < STACK_SIZE - 1) {
            content_[++top_] = value;
        } else {
            throw StackError(-1);
        }
    }
    
    int pop() {
        if (top_ > -1) {
            return content_[top_--];
        }
        throw StackError(-1);
    }
};

int main() {
    Stack st;
    try {
        st.push(1001);
    } catch (StackError e) {
        cout << "Pushing throwed StackError with error code " << e.get_code() << endl;
    } catch (TooBigValueError e) {
        cout << "Our stack does not support values over 1000" << endl;
    }
    
    try {
        for (int i = 0; i < 11; i++) {
            st.push(i);
        }
        st.push(1001);
    } catch (StackError e) {
        cout << "Pushing throwed StackError with error code " << e.get_code() << endl;
    } catch (TooBigValueError e) {
        cout << "Our stack does not support values over 1000" << endl;
    }
    
    for (int i = 0; i < 12; i++) {
        cout << st.pop() << endl;
    }
}
