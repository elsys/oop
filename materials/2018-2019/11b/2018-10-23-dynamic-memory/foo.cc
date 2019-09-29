#include <iostream>
using namespace std;

class Foo {
	int bar_;
public:
	Foo() : bar_(42)
	{
		cout << "Foo() called..." << endl;
	}

	Foo(int bar) :bar_(bar)
	{
		cout << "Foo(int) called..." << endl;
	}
	
	~Foo() {
		cout << "~Foo() called..." << endl;
	}
	
	int get_bar() const {
		return bar_;
	}
};

int main() {
	Foo f1;
	
	
	cout << "f1.bar_=" << f1.get_bar() << endl;

	Foo* fptr = (Foo*) malloc(sizeof(Foo));
	cout << "fptr->bar_=" << fptr->get_bar() << endl;	
	free(fptr);
	
	Foo* p1 = new Foo;
	Foo* p2 = new Foo(43);
	Foo* p3 = new Foo[3];
	

	delete p1;
	delete p2;
	
	delete [] p3;
	
	return 0;
}



