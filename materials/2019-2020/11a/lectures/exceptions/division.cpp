#include<iostream>
using namespace std;

class DivisionByZero{};
class TerminateException{};

double division(int a, int b) {
	if (b == 0) {
		throw DivisionByZero();
	};
	
	if(a == 6798) {
		throw TerminateException();
	};
	
	return a/b;
};

int main() {
	int a;
	int b;
	
	while(true) {
		cout << "Value of a: ";
		cin >> a;
		cout << "Value of b: ";
		cin >> b;
		double result;
		try{
			result = division(a, b);
		} catch (TerminateException) {
			cout << "Terminate requested!" << endl;
			return;
		} catch (DivisionByZero ex) {
			cout << "Can't divide by zero!" << endl;
			continue;
		}
		
		cout << "Result: " << result << endl;
	};
}







