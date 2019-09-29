#include <iostream>
#include <cstdlib>

using namespace std;

class Foo {
	int bar_;
public:

	Foo()
	: bar_(-1)
	{
		cout << "Foo() constructor called..." << endl;
	}
	/*
	Foo(const Foo& f) 
	: bar_(f.bar_)
	{
		cout << "Foo(const Foo&) called..." << endl;
	}
	*/
	
	~Foo() {
		cout << "~Foo() called..." << endl;
	}
	
	Foo& operator=(const Foo& other) {
		
	}
	
	int get_bar() const {
		return bar_;
	}

};


void foo_get_bar(Foo f) {
	cout << f.get_bar() << endl;
}


int main() {

	{
		Foo f1;
		cout << f1.get_bar() << endl;
		foo_get_bar(f1);
	}
	
	// f1.get_bar();
	
/*
	Foo* pf1 = (Foo*) malloc(sizeof(Foo));
	cout << pf1 -> get_bar() << endl;
	free(pf1);
	
	Foo* pf2 = new Foo;
	cout << pf2 -> get_bar() << endl;
	delete pf2;
	
	Foo* pf3 = new Foo[3];
	delete [] pf3;
*/

  return 0;
}
