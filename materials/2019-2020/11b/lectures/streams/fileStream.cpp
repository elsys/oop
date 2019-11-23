#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
	
	ofstream out;
	out.open("test.txt");
	
	string name;
	cout << "Enter your name: ";
	getline(cin, name);
	
	out << name << endl;
	
	int age;
	cout << "Enter your age: ";
	cin >> age;
	
	out << age;
	
	out.close();
	
	ifstream in;
	in.open("test.txt");
	
	string iName;
	getline(in, iName);
	cout << iName << endl;
	
	int iAge;
	in >> iAge;
	cout << iAge << endl;
}












