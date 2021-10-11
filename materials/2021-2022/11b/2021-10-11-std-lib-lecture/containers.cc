#include <iostream>
#include <list>
#include <map>
#include <vector>

using namespace std;

int main() {
  list<int> list1;
  list1.push_back(42);
  list1.push_back(30);
  list1.push_front(20);
  
  //list1.push_back("asd");
  list1.pop_back();
  
  cout << list1.front() << " " << list1.back() << endl;
  
for(list<int>::iterator it = list1.begin(); it!=list1.end(); it++) {
    cout << (*it) << endl;
    //cout << it << endl;
  }
  
  map<list<int>, vector<char>> map1;
  
  for(map<list<int>, vector<char>>::iterator it = map1.begin(); it != map1.end(); it++) {
    /*class pair {
      public:
        list<int> first;
        vector<char> second;
    }*/
    list<int> key = it->first;
    vector<char> value = it->second;
  }
  
  vector<char> vec1;
//  vec1.reserve(10);
  vec1.resize(10);
  vec1[3] = 'a';
  
  for(auto it = vec1.begin(); it!=vec1.end(); it++) {
    cout << (*it) << endl;
  }
  
  for(int i = 0; i < vec1.size(); i++) {
    cout << vec1[i] << endl;
  }
  
  return 0;
}
