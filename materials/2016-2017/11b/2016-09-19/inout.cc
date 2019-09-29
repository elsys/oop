#include <iostream>
using namespace std;




int main() {
	double val=0;

	cout << "Enter double value:" << endl;
	cin >> val;
	if(!cin) {
		cerr << "BAD INPUT" << endl;
	}

	cout << "Value=" << val << endl;


	return 0;
}

