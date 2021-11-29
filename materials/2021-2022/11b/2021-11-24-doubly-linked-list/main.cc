#include "list.hh"

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

  return 0;
}
