#include <iostream>

using namespace std;

template<class T>
//template<typename T>
void copy_template(const T* src, T* dest, int size) {
	for (int i = 0; i < size; i++) {
		dest[i] = src[i];
	}
}

template<typename Number>
Number max_template(const Number& n1, const Number& n2) {
	return n1 > n2 ? n1 : n2;
}

int main() {
	double c[] = {0.1, 0.3, -0.4, 0.8};
	double d[4];

	copy_template(c, d, 4);

	for (int i = 0; i < 4; i++) {
		cout << d[i] << " ";
	}
	cout << endl;
	
	cout << max_template(15, 21) << " " << max_template(0.4, 0.15) << endl;
}
