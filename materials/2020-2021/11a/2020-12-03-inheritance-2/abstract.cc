#include <iostream>
using namespace std;

class Bird {
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

class Platypus : public Bird, public Mammal {
public:
  void fly() override {
    cout << "i can fly in a special way" << endl;
  }
  
  void walk() {
    cout << "i can walk a special way" << endl;
  }
};

void do_bird_stuff(Bird& bird) {
  bird.fly();
}

int main() {
  Platypus my_test;
  
  my_test.fly();
  my_test.walk();
  
  do_bird_stuff(my_test);
  
  Bird eagle;
  do_bird_stuff(eagle);
  
  return 0;
}
