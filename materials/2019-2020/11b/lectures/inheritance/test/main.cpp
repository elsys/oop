#include <iostream>
using namespace std;

class A {
	int a = 1;
	public:
		int b = 2;
		int getA() {
		 return a;
		}
	protected:
		int c = 3;
};

class B : public A {
	int d = 4;
	public:
		int e = 5;
		int getC() {
			return this -> getA();
		}
	protected:
		int f = 6;
};

int main() {
	A a;
	B b;
	//cout << a.a << endl;
	cout << a.b << endl;
	//cout << a.c << endl;
	//cout << b.a << endl;
	//cout << b.b << endl;
	//cout << b.c << endl;
	//cout << b.d << endl;
	cout << b.e << endl;
	//cout << b.f << endl;
	cout << b.getC() << endl;
	b.getA();
}
