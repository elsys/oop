#include <iostream>
#include <string>
using namespace std;



int main() {
	string word;
	
	//	while(cin.good()) {
	while(cin) {
		cin >> word;
		if(!cin) {
			break;
		}
		cout << "|" << word << "|" << endl;
	}

	

	return 0;
}

