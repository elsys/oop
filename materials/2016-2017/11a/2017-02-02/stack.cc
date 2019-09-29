#include <iostream>
using namespace std;

class StackError {};

template<typename T>
class Stack {
	const static int SIZE_ = 10;
	int top_;
	T data_[SIZE_];
public:
	Stack()
	: top_(0)
	{}
	bool empty() const {
		return (top_ == 0);
	}
	bool full() const {
		return top_ == SIZE_;
	}
	void push(const T& val) {
		if(full()) {
			throw StackError();
		}
		data_[top_++] = val;
	}
	const T& pop() {
		if(empty()) {
			throw StackError();
		}
		return data_[--top_];
	}
	
	void print_all() const {
		for(int i=0;i<top_; ++i) {
			cout << data_[i] << ", ";
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
	double get_x() const {
		return x_;
	}
	double get_y() const {
		return y_;
	}
};

ostream& operator<<(ostream& out, Point p) {
	out << p.get_x() << "," << p.get_y();
	return out;
}

int main() {
	Stack<int> st;
	cout << st.empty() << endl;
	cout << st.full() << endl;
	
	st.push(10);
	cout << st.empty() << endl;
	cout << st.pop() << endl;
	
	for(int i=0; i<10; ++i) {
		st.push(i*13);
	}
	st.print_all();
	
	Stack<Point> sp;
	Point p1, p2;
	sp.push(p1);
	sp.push(p2);
	
	sp.print_all();
	
	return 0;
}
