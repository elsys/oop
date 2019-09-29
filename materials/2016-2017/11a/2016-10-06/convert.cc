#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
	string word;
	// double word;
	
	while(cin) {
		cin >> word;
		if(!cin) {
			break;
		}
		cout << "|" << word << "|" << endl;
		
		istringstream in(word);
		double val=0;
		in >> val;
		if(in && in.eof()) {
			cout << "double value: " << val << endl;
		} else {
			cout << "not a double: " << word << endl;
		}
		
	}


	return 0;
}

