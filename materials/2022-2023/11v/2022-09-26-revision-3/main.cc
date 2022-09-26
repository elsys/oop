#include <iostream>
#include <list>

using namespace std;

int main() {
  list<int> l1;

  l1.push_back(5);
  l1.push_back(19);

  l1.pop_front();

  cout << l1.size() << endl;
  cout << l1.front() << endl;

  l1.pop_front();
  cout << l1.front() << endl;

  l1.push_back(5);
  l1.push_back(19);
  l1.push_back(2);
  l1.push_back(3);
  l1.push_back(67);
  l1.push_back(43);

  // for(int i = 0; i < l1.size(); i++) {
  //   int val = l1.front();
  //   l1.pop_front();
  //   cout << i << " " << val << endl;
  //   l1.push_back(val);
  // }
  int i =0;
  for(
    //list<int>::iterator it = l1.begin();
    /*auto it = l1.begin();
    it != l1.end();
    it++*/
    auto val : l1
  ) {
    //cout << i++ << " " << *it << endl;
    cout << i++ << " " << val << endl;
  }

  return 0;
}