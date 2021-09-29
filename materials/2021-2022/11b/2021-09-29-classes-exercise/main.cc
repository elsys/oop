#include "list.hh"

int main() {
  List my_list;
  
  my_list.push(4);
  my_list.push(8);
  my_list.push(-2);
  
  my_list.print();
  
  return 0;
}
