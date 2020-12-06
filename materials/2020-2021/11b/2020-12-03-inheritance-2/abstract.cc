#include <iostream>
using namespace std;

class IBird {
public:
  /*void fly() {
    cout << "i can fly" << endl;
  }*/
  virtual void fly() = 0;
};

class Mammal {
public:
  void walk() {
    cout << "i can walk" << endl;
  }
};

class Platypus : public IBird, public Mammal {
public:
  void fly() {
    cout << "i can fly and i'm special" << endl;
  }
  
  void walk() {
    cout << "i can walk and i'm special" << endl;
  }
};

class Penguin : public IBird {};

void do_bird_stuff(IBird& bird) {
  bird.fly();
}

int main() {
  Platypus my_test;
  
  my_test.fly();
  my_test.walk();
  
  do_bird_stuff(my_test);
  
  Penguin my_pengu;
  do_bird_stuff(my_pengu);
  
  return 0;
}
