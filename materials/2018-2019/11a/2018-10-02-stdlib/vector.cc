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
	
	
	for(int i=0; i< v1.size(); ++i) {
		cout << "v1[" << i << "]=" << v1[i] << endl;
		v1[i] *=2;
		cout << "v1[" << i << "]=" << v1[i] << endl;
		cout << "v1.at(" << i << ")=" << v1.at(i) << endl;
	}
	
	// cout << v1[6] << endl;
	// cout << v1.at(6) << endl;
	
	cout << "v1.front()=" << v1.front() << endl;
	cout << "v1.back()=" << v1.back() << endl;
	
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;
	v1.pop_back();
	cout << "v1.size()=" << v1.size() << endl;
	cout << "v1.capacity()=" << v1.capacity() << endl;
	// v1.pop_front();


	int sum = 0;
	for(vector<int>::iterator it=v1.begin(); it!=v1.end(); ++it) {
		cout << "*it=" << *it << endl;
		sum += *it;
	}	
	
	cout << "sum=" << sum << endl;
	
	vector<int> v2(10, 0);
	for(int i=0; i<v2.size(); ++i) {
		cout << "v2[" << i << "]=" << v2[i] << endl;
		v2[i] = i;
		cout << "v2[" << i << "]=" << v2[i] << endl;
	}


	vector<int> v3(v2.begin(), v2.end());	
	for(int i=0; i<v3.size(); ++i) {
		cout << "v3[" << i << "]=" << v3[i] << endl;
	}
	
	return 0;
}


/*
HW:

* http://lubo.elsys-bg.org/wp-content/uploads/2009/03/04-std.pdf

* Stack based vector


*/



