#include <iostream>

using namespace std;

int make_order() {
  static int counter = 0;
  
  cout << "Ordering pizza..." << endl;
  counter++;
  
  return counter;
}

void do_some_work() {
  cout << make_order() << endl;
}

class Pizzeria {
public:
  Pizzeria() {  }
  Pizzeria(int arg1, int arg2, int arg3) {  }
  
  static int create_pizza() {
    return 5;
  }
};

class Math {
  Math() {}
public:
  static constexpr float PI = 3.14f;
  
  static int add(int a, int b) {
    return a + b;
  }
};

namespace Math_v2 {
  int add(int a, int b) {
    return a + b;
  }
}

class Factory {
public:
  static Pizzeria create_pizzeria() {
    Pizzeria p1 = Pizzeria(1, 2, 3);
    return p1;
  }
};

int main() {
  //int counter = 0;

 // make_order(&counter);
  
  cout << make_order() << endl;
  //cout << counter << endl;
  
  do_some_work();
  do_some_work();
  do_some_work();
  
  Pizzeria p1;
  //cout << p1.create_pizza() << endl;
  cout << Pizzeria::create_pizza() << endl;
  
  cout << Math::add(4, 5) << endl;
  cout << Math_v2::add(4, 5) << endl;
  cout << Math::PI << endl;
  
  //Math math1;
  
  return 0;
}
