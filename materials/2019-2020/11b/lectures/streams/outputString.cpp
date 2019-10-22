#include <iostream>
#include <sstream>
#include <string>
using namespace std;

int main() {
	ostringstream out;
	
	string test = "test";
	test += "123";
	
	out << "test" << " " << "123" << ", " << 123 << "\n";
	
	string data = out.str();
	
	cout << "data: " << data << endl;
}
