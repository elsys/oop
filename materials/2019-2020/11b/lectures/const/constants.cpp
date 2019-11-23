#include <iostream>
using namespace std;

int main() {
	const int i = 5;
	//i = 3;
	
	char str1[] = "Hello";
	char str2[] = "Alo";
	
	const char* p1 = str1;
	p1 = str2;
	//p1[2] = 'A';
	
	char* const p2 = str1;
	//p2 = str2;
	p2[2] = 'A';
	
	const char* const p3 = str1;
	//p3 = str2;
	//p3[2] = 'A';
	cout << p3 << endl;
	
	int a = 2;
	int& ra = a;
	cout << ra << endl;
	ra = 3;
	cout << a << endl;
	
	const int& cra = a;
	cout << cra << endl;
	//cra = 2;
	
	int b = 10;
	int& ra2 = a;
	ra2 = b;
	cout << a << endl;

}
