#include<iostream>
#include<sstream>
#include<string>
using namespace std;

int main() {
	string test = "3.14 4k";
	
	istringstream in(test);
	
	double pi;
	in >> pi;
	
	if(in.good()) {
		cout << "Everything is ok" << endl;
		cout << "pi: " << pi << endl;
	} else {
		cout << "Something went wrong!" << endl;
	}
	
	int number;
	in >> number;
	if(in.good()) {
		cout << "eVERYTHING IS OK" << endl;
		cout << "number: " << number << endl;;
	} else {
		cout << "Something went wrong!" << endl;
	}
	
	in.clear();
	
	string end;
	in >> end;
	
	if(!in.fail()) {
		cout << "eVERYTHING IS OK" << endl;
		cout << "end: " << end << endl;
	} else {
		cout << "Something went wrong!" << endl;
	}
	
	if(in.eof()) {
		cout << "At the end of the stream" << endl;
	}
}
