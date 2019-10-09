#include <iostream>
#include <string>
using namespace std;

int main() {
	string firstName;
	string lastName;
	cout << "Enter first name" << endl;
	getline(cin, firstName);
	cout << "Enter last name" << endl;
	getline(cin, lastName);
	cout << "Full name: " << firstName + " "+ lastName << endl;
	cout << "First name length: " << firstName.length() << endl;
	cout << "First name capacity: " << firstName.capacity() << endl;
	cout << "Enter full name: " << endl;
	string fullName;
	getline(cin, fullName);
	cout << "Full name: " << fullName << endl;
}
