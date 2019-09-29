#include <iostream>
using namespace std;

#define STACK_MEM_STEP 3

class StackError{};

class Stack {
	int top_;
	int capacity_;
	int* data_;
	
	void resize() {
		cout << "resize() called..." << endl;
	
		capacity_ += STACK_MEM_STEP;
		int* new_data = new int[capacity_];
		
		for(int i=0; i<top_; ++i) {
			new_data[i] = data_[i];
		}
		delete [] data_;
		data_ = new_data;
	}
	
public:
	Stack()
	: top_(0),
	  capacity_(STACK_MEM_STEP),
	  data_(new int[capacity_])
	{}
	
	Stack(const Stack& other)
	: top_(other.top_),
	  capacity_(other.capacity_),
	  data_(new int[capacity_])
	{
		cout << "Stack(const Stack&) called..." << endl;
		for(int i=0; i< top_; ++i) {
			data_[i] = other.data_[i];
		}
	}
	
	
	Stack& operator=(const Stack& other) {
	
		if(this != &other) {
			delete [] data_;
			
			top_ = other.top_;
			capacity_ = other.capacity_;
			data_ = new int[capacity_];
			
			for(int i=0; i<top_; ++i) {
				data_[i] = other.data_[i];
			}
		}
		return *this;
	}
	
	~Stack() {
		cout << "~Stack() called..." << endl;
		delete [] data_;
	}
	
	bool empty() const {
		return top_ == 0;
	}
	int capacity() const {
		return capacity_;
	}
	int size() const {
		return top_;
	}
	
	void push(int val) {
		if(top_ >= capacity_) {
			// resize()!!!
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
	cout << "empty: " << st.empty() << endl;
	cout << "size:  " << st.size() << endl;
	cout << "cap:   " << st.capacity() << endl;
	
	st.push(1);
	st.push(2);
	
	cout << "empty: " << st.empty() << endl;
	cout << "size:  " << st.size() << endl;
	cout << "cap:   " << st.capacity() << endl;
	
	cout << st.pop() << endl;
	cout << st.pop() << endl;

	cout << "empty: " << st.empty() << endl;
	cout << "size:  " << st.size() << endl;
	cout << "cap:   " << st.capacity() << endl;

	for(int i=0;i<16;++i) {
		st.push(i);
	}
	
	cout << "size:  " << st.size() << endl;
	cout << "cap:   " << st.capacity() << endl;

	Stack st2=st;
	cout << "size:  " << st2.size() << endl;
	cout << "cap:   " << st2.capacity() << endl;
	
	Stack st3;
	
	// ....
	
	st3 = st;
	

	return 0;
}

