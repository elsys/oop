#include <iostream>
#include <sstream>
#include <string>
using namespace std;

int main() {
	ostringstream out;
	
	out << "test" << " 123" << "\n";
	
	string data = out.str();
	
	cout << "data: " << data << endl;
}
