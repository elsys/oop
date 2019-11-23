#include <iostream>
#include <sstream>
#include <string>
using namespace std;

int main() {
	string data = "3.1415 ske";
	
	istringstream in(data);
	
	double pi;
	in >> pi;
	if(in.good()) {
		cout << "Everything is OK" << endl;
		cout << "pi: " << pi << endl;
	} else {
		cout << "Something went wrong!" << endl;
	}
	
	int number;
	in >> number;
	
	if(in.good()) {
		cout << "Everything is OK" << endl;
		cout << "number: " << number << endl;
	} else {
		cout << "Something went wrong" << endl;
	}
	
	in.clear();
	
	string end = "not set";
	in >> end;
	
	if(in) {
		cout << "Everything is ok" << endl;
		cout << "End:" << end << endl;
	} else {
		cout << "Stream is not OK" << endl;
		cout << "End:" << end << endl;
	}
	
	if(in.eof()) {
		cout << "Reached the end" << endl;
	}
}















