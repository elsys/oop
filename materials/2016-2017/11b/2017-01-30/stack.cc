#include <iostream>
using namespace std;

class StackError {};

template<class T>
class stack {
	const static int SIZE = 10;
	int top_;
	T data_[SIZE];
public:
	stack()
	: top_(0)
	{}
	
	bool empty() const {
		return top_ == 0;
	}
	
	bool full() const {
		return top_ == SIZE;
	}
	
	void push(const T& val) {
		if(full()) {
			throw StackError();
		}
		data_[top_++] = val;
	}
	
	T pop() {
		if(empty()) {
			throw StackError();
		}
		return data_[--top_];
	}
	
	
	void print_all() const {
		for(int i = 0; i< top_; ++i) {
			cout << data_[i] << "; ";
		}
		cout << endl;
	}
};

class Point {
	double x_, y_;
public:
	Point()
	: x_(0), y_(0)
	{}
};


int main() {
	stack<int> st;

	cout << st.empty() << endl;
	st.push(55);
	cout << st.empty() << endl;
	cout << st.pop() << endl;
	cout << st.empty() << endl;

	st.push(5.15);
	cout << st.pop() << endl;
		
	int a = 5.15;
	cout << a << endl;
	
	for(int i=0; i<10; ++i) {
		st.push(10*i);
	}
	
	st.print_all();


	stack<Point> sp;
	Point p1;
	
	sp.push(p1);
	sp.pop();
	// sp.print_all();
	
	return 0;
}

