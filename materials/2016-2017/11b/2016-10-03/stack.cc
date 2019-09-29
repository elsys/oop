#include <list>
#include <iostream>
using namespace std;

class StackError {};

class Stack {

	list<int> data_;
public:
	Stack() {
	
	}
	
	void push(int val) {
		data_.push_back(val);
	}
	
	int pop() {
		if(data_.empty()) {
			throw StackError();
		}
		int val = data_.back();
		data_.pop_back();
		return val;
	}

};



int main() {
	Stack st;
	
	st.push(10);
	st.push(20);
	
	cout << st.pop() << endl;

	return 0;
}

