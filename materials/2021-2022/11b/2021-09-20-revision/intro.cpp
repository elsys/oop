//#include <stdio.h>
#include <iostream>

void foo() {
  std::cout << "TEST" << std::endl;
}

int main() {  
  using namespace std;
  //printf("Hello world\n");
  //std::cout << "Hello world" << std::endl;
  cout << "Hello world" << endl;
  foo();
  
  int a = 5;
  cin >> a;
  
  cout << a << " " << &a << endl;
  
  return 0;
}

