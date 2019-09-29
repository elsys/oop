#include <iostream>
using namespace std;

void inc(int& v) {
	v+=1;
}

int main() {
	int a = 1;
	int b = 2;
	
	int& ra = a;
	int& rb = b;
	
	ra+=1;
	rb+=2;
	
	inc(a);


	return 0;
}


