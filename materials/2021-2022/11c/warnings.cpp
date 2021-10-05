#include <iostream>

using std::cout;

double add(double a, double b)
{
	return a + b;
}

int main(int argc, char *argv[])
{
	int total = add(3, 4);
	
	cout << "3 + 4 is " << total << "\n\n";
	
	// compile with -Wall
	// example
	// g++ -o warnings.exe warnings.cpp -Wall
	double sum = add(3.3, 4.4);
	
	cout << "3.3 + 4.4 is " << total << "\n\n";
	
	return 0;
}