#include <iostream>
using namespace std;


class Foo {
	int bar_;

public:
	
	Foo()
	: bar_(-1)
	{
		cout << "Foo() called..." << endl;
	}

	Foo(int bar)
	: bar_(bar)
	{
		cout << "Foo(" << bar_ << ") called..." << endl;
	}

	Foo(const Foo& other)
	: bar_(other.bar_)
	{
		cout << "Foo(const Foo&) called..." << endl;
	}

	
	~Foo() {
		cout << "~Foo() called..." << endl;
	}
	
	Foo& operator=(const Foo& other) {
		bar_ = other.bar_;
		return *this;
	}
	
	int get_bar() const {
		return bar_;
	}
};
void report_bar(Foo foo) {
	cout << "foo.get_bar(): " << foo.get_bar() << endl;
}
int main() {
	Foo foo;
	Foo f42(42);
	foo = f42;
	report_bar(foo);
	Foo f1(foo);
	Foo f2=foo;

	f1 = f2 = foo;
	
	int a;
	int b;
	int c;
	
	c = 0;
	a = (b = c);
	
	return 0;
}

