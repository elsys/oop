#include <iostream>
#include <string>

using namespace std;


int main() {
	string s1("Hello");
	string s2 = "W";
	
	
	cout << s1 << ' ' << s2 << endl;

	string s;
	
	s = s1 + " " + s2;
	cout << s << endl;


	for(int i = 0; i<s.size(); ++i) {
		cout << s[i] << endl;
	}
	
	for(string::iterator it = s.begin(); it!=s.end(); ++it) {
		cout << *it << endl;
	}
	
	s.push_back('!');
	s.push_back('!');
	s.push_back('!');
	s.push_back('!');
	
	cout << s << endl;
	
	string sstr = s.substr(0,4);
	cout << sstr << endl;
	
	int index = s.find("Wo");
	cout << "index of 'Wo'=" << index << endl;
	index = s.find("Wo", 7);
	cout << "index of 'Wo'=" << index << endl;
	if(index == string::npos) {
		cout << "string 'Wo' not found..." << endl;
	}
	
	if(s1 != s2) {
		cout << "s1 and s2 are not equal..." << endl;
	}
	
	if(s1 < s2) {
		cout << "s1 is less than s2!!" << endl;
	}
	return 0;
}

