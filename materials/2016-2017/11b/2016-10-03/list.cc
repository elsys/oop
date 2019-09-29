#include <list>
#include <iostream>
using namespace std;

void print_all(list<int>& li) {
	cout << "list: " ;
	for(list<int>::iterator it = li.begin();it!=li.end(); ++it) {
		cout << *it << ' ';
	}
	cout << endl;
}

void set_val(int& val) {
	val = 42;
}


int main() {
	int v = 0;
	set_val(v);
	cout << v << endl;
	

	list<int> li;
	
	list<double> ld;
	
	cout << "li.empty()=" << li.empty() << endl;
	
	li.push_back(1);
	li.push_back(2);
	
	cout << "li.empty()=" << li.empty() << endl;
	
	li.push_front(-1);
	li.push_front(-2);

	cout << "li.empty()=" << li.empty() << endl;
	print_all(li);
	
	cout << li.front() << endl;
	cout << li.back() << endl;	

	list<int>::iterator it = li.begin();
	cout << *it << endl;
	it ++; it ++;
	cout << *it << endl;
	
	li.insert(it, 0);
	print_all(li);
	li.insert(li.begin(), -10);
	li.insert(li.end(), 10);
	print_all(li);
	
	it = li.begin();
	li.erase(it);
	
	it = li.end();
	it--;
	
	li.erase(it);
	
	print_all(li);
	li.pop_front();
	li.pop_back();
	print_all(li);
	
	
	li.erase(li.begin(), li.end());
	print_all(li);
	
	
	
	return 0;
}

