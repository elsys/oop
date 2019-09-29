


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
	
	void push(int val) {
		if(full()) {
			cout << "OOPPSSS! stack is full..." << endl;
			return;
		}
		data_[top_++] = val;
	}
	int pop() {
		if(empty()) {
			cout << "OOOPPPPPSSSS!!!! stack is empty..." << endl;
			return 0;
		}
		return data_[--top_];
	}
};


int main() {
	Stack st;
	
	cout << "empty? " << boolalpha << st.empty() << endl;
	cout << "full?  " << st.full() << endl;
	
	st.push(0);
	st.push(1);
	st.push(2);
	
	cout << "empty? " << boolalpha << st.empty() << endl;
	cout << "full?  " << st.full() << endl;
	
	while(!st.empty()) {
		cout << "pop=" << st.pop() << endl;
	}

	st.pop();
	
	return 0;
}

