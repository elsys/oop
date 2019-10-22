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
	
	out << name;
	out << "\n";
	
	int age;
	cout << "Enter your age: ";
	cin >> age;
	
	out << age;
	
	out.close();
	
	
	ifstream in;
	in.open("test.txt");
	
	string nameI;
	getline(in, nameI);
	cout << nameI << endl;
	
	int ageI;
	in >> ageI;
	cout << ageI << endl;
}

