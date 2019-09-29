#include <iostream>
#include <list>

using namespace std;

class StackError {};

class Stack {
	
	list<int> data_;
public:
	Stack() {
	}
	
	bool empty() {
		return data_.empty();
	}


	void push(int val) {
		data_.push_back(val);
	}
	
	int pop() {
		if(empty()) {
			throw StackError();
		}
		int val = data_.back();
		data_.pop_back();
		return val;
	}
};


int main() {
	Stack st;
	
	cout << st.empty() << endl;
	for(int i=0; i<20; ++i) {
		st.push(i*42);
	}
	while(!st.empty()) {
		cout << st.pop() << endl;
	}
	
	return 0;
}


