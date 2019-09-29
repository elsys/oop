#include <iostream>
using namespace std;

void print();

int main() {
	
	extern int a;

	cout << a << endl;

	print();

	return 0;
}

