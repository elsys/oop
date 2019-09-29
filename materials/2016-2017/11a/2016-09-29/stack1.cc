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

	int push(int val) {
		if(full()) {
			cerr << "stack is full..." << endl;
			return -1;
		}
		data_[++top_] = val;
		return 0;
	}

	int pop(int& val) {
		if(empty()) {
			cerr << "stack is empty..." << endl;
			return -1;
		}
		val = data_[top_--];
		return 0;
	}
};



int main() {
	Stack st;

	cout << st.empty() << endl;
	st.push(14);
	
	int val = 0;
	
	cout << st.empty() << endl;
	cout << st.pop(val) << endl;
	cout << val << endl;
	cout << st.empty() << endl;
	
	
	for(int i=0; i < STACK_SIZE; i++) {
		st.push(i*42);
	}
	if(st.push(42) == -1) {
		cerr << "OOOOOOPS!!!!" << endl;
	}
	
	while(!st.empty()) {
		cout << st.pop(val) << endl;
		cout << val << endl;
	}
	if(st.pop(val) == -1) {
		cerr << "OOOOOPS AGAIN!!!" << endl;
	}
	
	return 0;
}

