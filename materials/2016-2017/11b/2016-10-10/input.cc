#include <iostream>
#include <string>
#include <sstream>
#include <fstream>

using namespace std;


int main() {
	string word;
	// double word;
	
	ifstream fin("file.txt");
	
	wchar_t wch;
	
	//while(cin) {
	while(cin.good()){
		cin >> word;
		if(!cin) {
			break;
		}
		
		istringstream in(word);
		double val=0.0;
		in >> val;
		if(in && in.eof()) {
			cout << "double: " << val << endl;
			ostringstream out;
			out << val;
			string oval = out.str();
			cout << "string double: " << oval << endl;
			
		} else {
			cout << "not a double: " << word << endl;
		}
		
		cout << "|" << word << "|" << endl;
	}

	return 0;
}


