#include <iostream>
#include <cstdlib>
using namespace std;

class Foo {
	int bar_;
public:

	Foo(int b): bar_(b) 
	{
		cout << "Foo(" << bar_ << ") called..." << endl;
	}
	Foo() :bar_(42)
	{
		cout << "Foo() called..." << endl;
	}

	~Foo() {
		cout << "~Foo() called..." << endl;
	}	

	int get_bar() {
		return bar_;
	}	
};


int main() {
	Foo f1;
	cout << "f1.get_bar()=" << f1.get_bar() << endl;

	Foo* fp = (Foo*) malloc(sizeof(Foo));
	cout << "fp->get_bar()=" << fp->get_bar() << endl;	
	free(fp);
	
	Foo* p1 = new Foo;
	Foo* p2 = new Foo(43);
	Foo* p3 = new Foo[3];
	
	delete p1;
	delete p2;
	delete [] p3;

	return 0;
}

