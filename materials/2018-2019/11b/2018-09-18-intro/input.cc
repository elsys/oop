#include <iostream>
using namespace std;


int main() {
	int val;

	while(true) {
		cin >> val;
		if(!cin) {
			break;
		} else {
			cout << val << endl;
		}
	}
	return 0;
}

