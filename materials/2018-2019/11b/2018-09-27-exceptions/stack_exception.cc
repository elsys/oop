#include <iostream>
#include <string>

using namespace std;

#define STACK_SIZE 10

class Exception {
	string error_message_;

public:
	Exception(string msg) {
		error_message_ = msg;
	}

	string get_message() {
		return error_message_;
	}
};

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

	void push(int val) {
		if(full()){
			throw Exception("Stack is full");
		}
		data_[top_++] = val;
	}
	int pop() {
		if(empty()) {
			throw Exception("Stack is empty");
		}
		return data_[--top_];
	}
};


int main() {
	Stack st;

	try {
		for (int i = 0; i < 11; i++) {
			st.push(i * 10);
			cout << i * 10 << endl;
		}

	} catch (Gosho e) {

	} catch (Exception e) {
		cout << e.get_message() << endl;
	}

	try {
		for (int i = 0 ; i < 11; i++) {
			cout << st.pop() << endl;
		}
	} catch (Exception e) {
		cout << e.get_message() << endl;
	}

	return 0;
}
