#include <iostream>
using namespace std;

int main() {
	int val;

	while(true) {
		cout << "val=";
		cin >> val;
		if( !cin ) {
			break;
		}
		cout << "val = " << val << endl;
	}
	return 0;
}

