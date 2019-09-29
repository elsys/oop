#include <iostream>
using namespace std;


class Increment {
	int count_;
	const int step_;

public:

	Increment(int count, int step) 
	: count_(count), step_(step)
	{
		// count_ = count;
		// step_ = step;
	}
	
	void step() {
		count_ += step_;
	}
	
	int get() {
		return count_;
	}

};


int main() {
	Increment inc(0, 3);
	for(int i=0; i<10; ++i) {
		inc.step();
	}

	cout << "inc.get(): " << inc.get() << endl;

	return 0;
}

