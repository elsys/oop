#include <iostream>

using std::cout;
using std::endl;

int add(int a, int b)
{
	cout << "add with 2 params called" << endl;
	return a + b;
}

int add(int a, int b, int c)
{
	cout << "add with 3 params called" << endl;
	
	// or you can do 
	// return add(a + b) + c;
	return a + b + c;
}

int main(int argc, char *argv[])
{
	int subtotal = add(1,2);
	cout << "subtotal is " << subtotal << endl;
	
	cout << endl;
	
	int total = add(1,2,3);
	cout << "total is " << total << endl;
	
    return 0;
}
