#include <iostream>
using namespace std;

#define STACK_SIZE 10

class Stack {
	int top_;
	int data_[STACK_SIZE];

public:
	Stack() {
		top_ = -1;
	}
	
	bool empty() {
		return top_ == -1;
	}

	bool full() {
		return top_ == STACK_SIZE - 1;
	}

	void push(int val) {
		if(full()) {
			cerr << "stack is full..." << endl;
			return;
		}
		data_[++top_] = val;
	}

	int pop() {
		if(empty()) {
			cerr << "stack is empty..." << endl;
			return 0;
		}
		return data_[top_--];
	}
};



int main() {
	Stack st;

	cout << st.empty() << endl;
	st.push(14);
	

	cout << st.empty() << endl;
	cout << st.pop() << endl;
	cout << st.empty() << endl;
	
	
	for(int i=0; i < STACK_SIZE; i++) {
		st.push(i*42);
	}
	st.push(42);
	
	while(!st.empty()) {
		cout << st.pop() << endl;
	}
	cout << st.pop() << endl;
	
	return 0;
}

