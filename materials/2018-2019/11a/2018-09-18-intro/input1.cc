#include <iostream>
using namespace std;

int main() {
	int val;

	while(true) {
		cin >> val;
		if( !cin ) {
			break;
		}
		cout << val << endl;
	}
	return 0;
}

