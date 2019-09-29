#include <iostream>
#include <exception>
using namespace std;

#define STACK_SIZE 10

template<typename T>
class Point {
	T x_;
	T y_;
public:

};

template<typename T>
class Stack {

	T data_[STACK_SIZE];
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
	
	
	void push(T val) {
		if(full()) {
			throw exception();
		}
		data_[top_++] = val;
	}
	
	T pop() {
		if(empty()) {
			throw exception();
		}
		return data_[--top_];
	}
};

int main() {
	Stack<int> int_stack;
	Stack<double> double_stack;
	
	cout << "int_stack.empty()=" << int_stack.empty() << endl;
	cout << "double_stack.empty()=" << double_stack.empty() << endl;
	
	cout << "int_stack.full()=" << int_stack.full() << endl;
	cout << "double_stack.full()=" << double_stack.full() << endl;

	for(int i=0; i< STACK_SIZE; ++i) {
		int_stack.push(i);
		double_stack.push(3.14*i);
	}

	cout << "int_stack.empty()=" << int_stack.empty() << endl;
	cout << "double_stack.empty()=" << double_stack.empty() << endl;
	
	cout << "int_stack.full()=" << int_stack.full() << endl;
	cout << "double_stack.full()=" << double_stack.full() << endl;

	while(!int_stack.empty()) {
		cout << "int_stack.pop()=" << int_stack.pop() << endl;
	}

	while(!double_stack.empty()) {
		cout << "double_stack.pop()=" << double_stack.pop() << endl;
	}

	cout << "int_stack.empty()=" << int_stack.empty() << endl;
	cout << "double_stack.empty()=" << double_stack.empty() << endl;
	
	cout << "int_stack.full()=" << int_stack.full() << endl;
	cout << "double_stack.full()=" << double_stack.full() << endl;

	return 0;
}

