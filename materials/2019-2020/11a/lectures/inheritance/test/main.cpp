#include <iostream>
using namespace std;

class A {
	int a = 1;
	public:
		int b = 2;
	protected:
		int c = 3;
};

struct S {
	int c;
	int a;
	int d;
}

class {
	int p;
	int c;
	public:
		getP();
		count();
}

class B : A {
	int d = 4;
	public:
		int e = 5;
	protected:
		int f = 6;
	public:
	int getC() {
		return c;
	}
};

int main() {
	A a;
	B b;
	
	//cout << a.a << endl;
	cout << a.b << endl;
	//cout << a.c << endl;
	//cout << b.a << endl;
	//cout << b.b << endl;
	cout << b.getC() << endl;
	//cout << b.d << endl;
	cout << b.e << endl;
	//cout << b.f << endl;
}
