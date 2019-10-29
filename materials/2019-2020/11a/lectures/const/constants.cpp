#include <iostream>
using namespace std;

void test(const char* pc) {
	//char* str = pc;
}

int main() {
	const int a = 5;
	char str1[] = "hello";
	char str2[] = "hello 2";
	
	const char* pc = str1;
	pc = str2;
	//pc[2] = 'A';
	//str1[2] = 'A';
	
	char* const cp = str1;
	//cp = str2;
	cp[2] = 'A';
	
	cout << str2 << endl;
	
	const char* const c = str1;
	//c = str2;
	//c[2] = 'A';
	
	int b = 5;
	int& rb = b;
	int t = 10;
	cout << rb << endl;
	rb = t;
	cout << b << endl;
	
	/*const int& crb = rb;
	cout << crb << endl;
	b = 10;
	cout << crb << endl;
	
	char d = 'A';
	char& pd = d;
	d = 'B';
	
	cout << pd << endl;
	//cout << sizeof(pd) << endl;
	*/
	
}
