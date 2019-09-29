#include <iostream>


using namespace std;

template<class T>
void copy1(T dst[], T src[], int size) {
	for(int i=0; i<size; ++i) {
		dst[i] = src[i];
	}
}


int main() {

	int a[10], b[10];
	double c[10], d[10];
	
	for(int i=0;i<10;++i) {
		a[i] = 10*i;
		c[i] = 1.1*i;
	}
	copy1<int>(b, a, 10);
	
	for(int i=0; i<10; ++i) {
		cout << b[i] << "; ";
	}
	cout << endl;

	copy1<double>(d, c, 10);
	for(int i=0; i<10; ++i) {
		cout << d[i] << "; ";
	}
	cout << endl;
	
	// copy1<double>(d, a, 10);

	return 0;
}

