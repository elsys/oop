#include <iostream>
using namespace std;


#define STACK_MEMORY_STEP 3

class StackException {};

class Stack {

	int top_;
	int capacity_;
	
	int* data_;
	
	void realloc() {
		cout << "realloc() called..." << endl;
		capacity_+=STACK_MEMORY_STEP;
		int* new_data = new int[capacity_];
		
		for(int i=0; i<top_; i++) {
			new_data[i] = data_[i];
		}
		
		delete [] data_;
		data_ = new_data;
	}
	
public:

	Stack()
	: top_(0),
	  capacity_(STACK_MEMORY_STEP),
	  data_(new int[capacity_])
	{}
	
	~Stack() {
		cout << "~Stack() called..." << endl;
		delete [] data_;
	}	
	
	bool empty() const {
		return top_ == 0;
	}
	
	int size() const {
		return top_;
	}
	
	int capacity() const {
		return capacity_;
	}

	void push(int val) {
		if(top_>= capacity_) {
			realloc();
		}
		data_[top_++] = val;
	}
	
	int pop() {
		if(top_ == 0) {
			throw StackException();
		}
		return data_[--top_];
	}
};


int main() {
	Stack st;
	
	cout << "st.empty(): " << st.empty() << endl;
	cout << "st.capacity(): " << st.capacity() << endl;
	
	st.push(1);
	st.push(2);
	
	cout << "st.empty(): " << st.empty() << endl;
	cout << "st.capacity(): " << st.capacity() << endl;
	cout << "st.size(): " << st.size() << endl;	
	
	cout << st.pop() << endl;
	cout << st.pop() << endl;

	cout << "st.empty(): " << st.empty() << endl;
	cout << "st.capacity(): " << st.capacity() << endl;
	cout << "st.size(): " << st.size() << endl;	

	for(int i=0; i<15; ++i) {
		st.push(i);
	}

	cout << "st.capacity(): " << st.capacity() << endl;
	cout << "st.size(): " << st.size() << endl;	

	Stack st2=st;

	Stack st3;
	st3=st;
	
	
	return 0;
}

