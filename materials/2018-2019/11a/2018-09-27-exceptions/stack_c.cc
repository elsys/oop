#include <iostream>
using namespace std;

#define STACK_SIZE 10

class Stack {
	int data_[STACK_SIZE];
	int top_;
	int status_;
public:

	Stack() {
		top_ = 0;
		status_ = 0;
	}
	
	int get_and_reset_status() {
			int result = status_;
			status_ = 0;
			return result;
	}
	
	bool empty() {
		return top_ == 0;
	}
	
	bool full() {
		return top_ == STACK_SIZE;
	}

	void push(int val) {
		if(full()) {
			status_ = -1;
			return;
		}
		status_ = 0;
		data_[top_++] = val;
	}

	int pop() {
		if(empty()) {
            status_ = -1;
            return 0;
		}
		status_ = 0;
		return data_[--top_];
	}
	
	int size();

};

int main() {
	Stack st;

	for (int i = 0; i < 11; i++) {
		int value = i * 111;
		st.push(value);
		if (st.get_and_reset_status() == -1) {
			// error handling
			cout << "OOOPPSSS!!! stack is full..." << endl;
		} else {
			cout << "pushed=" << value << endl;
		}
	}
	
	for (int i = 0; i < 11; i++) {
		int value = st.pop();
		if (st.get_and_reset_status() == -1) {
			// error handling
			cout << "OOPPSS!!! stack is empty..." << endl;
		} else {
			cout << "pop=" << value << endl;
		}
	} 
	
	while (!st.empty()) {
	}
	st.pop();
	
	return 0;
}

