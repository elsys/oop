#include <iostream>
#include <vector>
using namespace std;


int main() {
	vector<int> v1;
	
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.empty()=" << v1.empty() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;
		
	v1.push_back(0);
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;
	v1.push_back(1);
	
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;
	v1.push_back(2);
	
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;
	
	v1.push_back(3);
	v1.push_back(4);
	
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;


	cout << "v1.front()=" << v1.front() << endl;
	cout << "v1.back()=" << v1.back() << endl;

	v1.pop_back();
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;


	for(int i=0; i < v1.size(); ++i) {
		cout << "v1[" << i << "]=" << v1[i] << endl;
		cout << "v1.at(" << i << ")=" << v1.at(i) << endl;
	}
		
	// cout << v1[6] << endl;
	// cout << v1.at(6) << endl;
	
	int sum = 0;
	for(vector<int>::iterator it = v1.begin(); it!=v1.end(); ++it) {
		cout << "*it=" << *it << endl;
		sum += *it;
	}
	cout << "sum=" << sum << endl;


	v1.insert(v1.begin(), -1);
	v1.insert(v1.end(), 1000);
	vector<int>::iterator it1 = v1.begin(); //+2;
	it1++;
	it1++;
	v1.insert(it1, 42);
	for(vector<int>::iterator it = v1.begin(); it!=v1.end(); ++it) {
		cout << "*it=" << *it << endl;
	}
	
	
	vector<int> v2(10, 42);
	for(vector<int>::iterator it = v2.begin(); it!=v2.end(); ++it) {
		cout << "*it=" << *it << endl;
	}

	vector<int> v3(v1.begin(), v1.end());
	for(vector<int>::iterator it = v3.begin(); it!=v3.end(); ++it) {
		cout << "*it=" << *it << endl;
	}
	
	
	return 0;
}


/*
HW:

- http://lubo.elsys-bg.org/wp-content/uploads/2009/03/04-std.pdf

- Stack for int's based vector<int>

*/
