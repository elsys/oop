#include <iostream>
#include <string>
using namespace std;

#define STACK_SIZE 10

class StackError {
	string msg_;
public:
	StackError(string msg) {
		msg_ = msg;
	}
	string get_msg() {
		return msg_;
	}
};

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
			throw StackError("stack is full");
		}
		data_[++top_] = val;
	}

	int pop() {
		if(empty()) {
			cerr << "stack is empty..." << endl;
			throw StackError("stack is empty");
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
	try {
		// throw 42;
		st.push(42);
		cout << "this should not be printed..." << endl;
	} catch(StackError& ex) {
		cerr << "stack error exception cathced and handled..." << endl;
		cerr << "msg: " << ex.get_msg() << endl;
	} catch(int& ex) {
		cerr << "int expectpion: " << ex << endl;
	}
	cout << "after cache block..." << endl;
	
	try {

		while(!st.empty()) {
			cout << st.pop() << endl;
		}
		cout << st.pop() << endl;

	} catch(StackError ex) {
		cerr << "stack error exception catched: " << ex.get_msg() << endl;
	}
	return 0;
}

