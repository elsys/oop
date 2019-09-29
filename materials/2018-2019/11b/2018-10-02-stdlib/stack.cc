

#include <iostream>
#include <exception>

using namespace std;

#define STACK_SIZE 10

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

	Stack<int> ist;
	Stack<double> dst;
	
	cout << "ist.empty()=" << ist.empty() << endl;
	cout << "dst.empty()=" << dst.empty() << endl;

	cout << "ist.full()=" << ist.full() << endl;
	cout << "dst.full()=" << dst.full() << endl;

	for(int i=0; i<10; ++i) {
		ist.push(i);
		dst.push(i*3.14);
	}

	cout << "ist.empty()=" << ist.empty() << endl;
	cout << "dst.empty()=" << dst.empty() << endl;

	cout << "ist.full()=" << ist.full() << endl;
	cout << "dst.full()=" << dst.full() << endl;

	while(!ist.empty()) {
		cout << "ist.pop()=" << ist.pop() << endl;
	}

	while(!dst.empty()) {
		cout << "dst.pop()=" << dst.pop() << endl;
	}

	cout << "ist.empty()=" << ist.empty() << endl;
	cout << "dst.empty()=" << dst.empty() << endl;

	cout << "ist.full()=" << ist.full() << endl;
	cout << "dst.full()=" << dst.full() << endl;

	return 0;
}

