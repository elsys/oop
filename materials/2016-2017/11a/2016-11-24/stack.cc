#include <iostream>
using namespace std;

class StackError {};

class Stack {
	static const int CHUNK_SIZE = 5;
	
	int top_;
	int capacity_;
	int* data_;
	
	void resize() {
		cout << "resizing()..." << endl;
		int* old_data = data_;
		
		capacity_+= CHUNK_SIZE;
		data_ = new int[capacity_];
		
		for(int i=0; i<top_; ++i) {
			data_[i] = old_data[i];
		}
		
		delete [] old_data;
	}
	
public:
	Stack()
	: top_(0),
		capacity_(CHUNK_SIZE),
		data_(new int[capacity_])
	{}
	
	~Stack() {
		delete [] data_;
	}
	
	Stack(const Stack& other)
	: top_(other.top_),
	  capacity_(other.capacity_),
	  data_(new int[capacity_])
	{
		for(int i=0;i<top_; ++i) {
			data_[i] = other.data_[i];
		}
	}
	
	Stack& operator=(const Stack& other) {
	
		if(this != &other) {
			delete [] data_;
		
			top_ = other.top_;
			capacity_ = other.capacity_;
			data_ = new int[capacity_];
			for(int i=0; i< top_; ++i) {
				data_[i] = other.data_[i];
			}
		}
		return *this;
	}
	
	bool empty() const {
		return top_ == 0;
	}	  

	void push(int val) {
		if(top_ == capacity_) {
			resize();
		}
		data_[top_++] = val;
	}

	int pop() {
		if(empty()) {
			throw StackError();
		}
		return data_[--top_];
	}

};

int main() {
	Stack st;
	cout << boolalpha << st.empty() << endl;
	
	for(int i=0; i<10; ++i) {
		st.push(i*42);
	}
	
	Stack st1=st;
	
	while(!st1.empty()) {
		cout << "st1: " << st1.pop() << endl;
	}

	Stack st2;
	st2 = st;
	
	while(!st2.empty()) {
		cout << "st2: " << st2.pop() << endl;
	}
	
	st = st;
	
	while(!st.empty()) {
		cout << st.pop() << endl;
	}
	
	return 0;
}

