#include <iostream>
using namespace std;

void inc(int& v) {
	v+=1;
}

int& set() {
	int a = 42;
	return a; // bad!!!
}

int main() {

	int a = 0;
	int b = 0;

	int& ra = a;
	int& rb = b;
	
	ra+=42;
	rb+=43;

	inc(a);
	
	return 0;
}

