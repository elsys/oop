


#include <iostream>
using namespace std;

#define STACK_SIZE 10

class Stack {
	int data_[STACK_SIZE];
	int top_;
public:
	Stack() {
		top_ = 0;
	}
	bool empty() {
		return top_ == 0;
	}
	bool full() {
		return top_ == STACK_SIZE;
	}

	int push(int val) {
		if(full()) {
			return -1;
		}
		data_[top_++] = val;
		return 0;
	}
	int pop() {
		if(empty()) {
			return -1;
		}
		return data_[--top_];
	}
};


int main() {
	Stack st;

	for(int i = 0; i < 11; i++) {
		if(st.push(i * 10) == -1) {
			// error handling
			cout << "OOPPSSS! stack is full..." << endl;
		} else {
			cout << "push=" << i * 10 << endl;
		}
	}

	for (int i = 0; i < 11; i++) {
		int value = st.pop();

		if(value == -1) {
			cout << "OOOPPPPPSSSS!!!! stack is empty..." << endl;
		} else {
			cout << "pop=" << value << endl;
		}
	}

	return 0;
}
