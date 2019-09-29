#include <iostream>
#include <string>

using namespace std;

#define STACK_SIZE 10

class DummyException {};

class Exception {
	string message_;
	
public:
	
	Exception(string message) {
		message_ = message;
	}
	
	string get_message() {
		return message_;
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
		if(full()) {
			throw Exception("stack is full");
		}
		data_[top_++] = val;
	}
	int pop() {
		if(empty()) {
      throw Exception("stack is empty");
		}
		return data_[--top_];
	}
	
	int size();

};


int main() {
	Stack st;

	try {
		for (int i = 0; i < 11; i++) {
			int value = i * 111;
			st.push(value);
			cout << "push=" << value << endl;
		}
	
	} catch (DummyException e) {
		cout << "dummy exception" << endl;
	}	catch (Exception e) {
		cout << "OOOOPS!!! " << e.get_message() << endl;
	}

	try {
		for (int i = 0; i < 11; i++) {
			cout << "pop=" << st.pop() << endl;
		}
	} catch (Exception e) {
		cout << "OOOOPS!!! " << e.get_message() << endl;
	}

	
	return 0;
}

