
#include <iostream>
using namespace std;

class Increment {
	int counter_;
	const int step_;
public:

	Increment(int counter, int step) 
	: counter_(counter), step_(step)
	{
		// counter_ = counter;
		// step_ = step;
	}

	void step() {
		counter_ += step_;
	}
	
	int get() {
		return counter_;
	}

};


int main() {
	Increment inc(0, 3);
	for(int i=0; i<10; ++i) {
		inc.step();
	}
	cout << "inc.get()=" << inc.get() << endl;
	
	return 0;
}

