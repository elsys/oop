#include <iostream>
using namespace std;

namespace firstSpace {
	void say_hello() {
		cout << "Hello from first name space" << endl;
	}
	
	namespace innerSpace {
		void say_hello() {
		cout << "Hello from inner name space" << endl;
	}
	};
};

namespace secondSpace {
	void say_hello() {
		cout << "Hello from second name space" << endl;
	}
};

using namespace secondSpace;
int main() {
	firstSpace::innerSpace::say_hello();
	firstSpace::say_hello();
	secondSpace::say_hello();
}



