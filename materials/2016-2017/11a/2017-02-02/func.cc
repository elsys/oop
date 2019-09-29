#include <iostream>
using namespace std;


template<typename T>
void swap1(T& a, T& b) {
	T tmp = a;
	a = b;
	b = tmp;
}


template<class R, class T>
R func1(const T& a) {
	
	// ...
}

template<class R, class T>
R func2(const R& a, const T& b) {

	// ...
	
}

int main() {

	int a=5, b=6;
	swap1<int>(a, b);
	cout << "a=" << a << endl;
	cout << "b=" << b << endl;

	double c=3.14, d=6.28;
	swap1(c,d);
	cout << "c=" << c << endl;
	cout << "d=" << d << endl;


	// swap1(a,c);
	func1<int, double>(c);
	func1<int>(c);
	
	func2<int, double>(a,c);
	func2<int>(a,c);
	func2(a,c);
	
	return 0;
}

