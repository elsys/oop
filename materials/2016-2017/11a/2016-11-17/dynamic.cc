#include <iostream>
#include <cstdlib>
using namespace std;


class Foo {
	int bar_;
public:
	Foo()
	: bar_(-1)
	{
		cout << "Foo() cstr called..." << endl;
	}
	
	Foo(int bar) 
	: bar_(bar)
	{
		cout << "Foo(" << bar_ << ") cstr called..." << endl;
	}
	
	~Foo() {
		cout << "~Foo() called..." << endl;
	}
	
	int get_bar() const {
		return bar_;
	}


};


int main() {
	{
		Foo f1;
		cout << f1.get_bar() << endl;
	}
	
	Foo* pf1 = (Foo*) malloc(sizeof(Foo));
	cout << pf1->get_bar() << endl;
	free(pf1);
	
	
	Foo* pf2 = new Foo;
	cout << pf2->get_bar() << endl;
	delete pf2;
	
	// Foo farray[] = {Foo(), Foo()};
	
	Foo* pf3 = new Foo[4];
	for(int i=0; i<4; ++i) {
		cout << pf3[i].get_bar() << endl;
	}
	delete [] pf3;
	
	Foo* pf4 = new Foo(42);
	cout << pf4 -> get_bar() << endl;
	delete pf4;
	
	return 0;
}






