#include <iostream>
#include <vector>
using namespace std;

void print_vector(vector<int> v) {
	for(int i = 0; i<v.size(); i++) {
		cout << v[i] << endl;
	}
}

int main() {
	vector<int> v;
	
	for(int i =0; i<10; i++) {
		v.push_back(i);
	}
	
	print_vector(v);
	cout << "Capacity: " << v.capacity() << endl;
	v.shrink_to_fit();
	cout << "Capacity: " << v.capacity() << endl;
	v.resize(20);
	cout << "Capacity: " << v.capacity() << endl;
	
	v[3] = 12;
	v.shrink_to_fit();
	print_vector(v);
}
