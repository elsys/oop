// #include <iostream>
#include <cstdlib>

#include "list.hh"

// using namespace std;

int main() {
  // std::cout << "Hello, World!" << std::endl;
  List<int>* myList = new List<int>();
  // List* myList = (List*)malloc(sizeof(List));
  // int cout = 5;
  // std::cout << myList->value << std::endl;
  // std::cout << cout << std::endl;
  // free(myList);

  myList->push_back(10);
  myList->push_front(5);
  myList->push_back(15);
  myList->push_front(2);

  myList->print();

  delete myList;
  return 0;
}




// struct foo {
//   int a;
//   double b;
//   char c;
//   long d;
// } myFoo;

// void* myPtr = (void*)myFoo;


