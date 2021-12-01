#include <iostream>
#include "list.hh"

using namespace std;

int main() {
  List l1;
  l1.print();

  l1.grow();
  l1.print();

  l1.push_back(3);
  l1.push_back(4);
  l1.push_back(7);
  l1.push_front(8);
  l1.push_front(9);
  l1.print();

  List l2 = List(l1); // This will use the copy constructor
  // l2 = l1; // This will use the assignment operator
  l2.print();
  
  cout << "========" << endl;
  for(auto it = l1.begin(); it != l1.end(); it++) {
    int value = *it;
    cout << value << endl;
  }
  cout << "========" << endl;
  
  /*Iterator it;
  Iterator it();
  Iterator it = Iterator();*/
  
  //List::Iterator it1();
  //List::Iterator it2(nullptr);

  return 0;
}
