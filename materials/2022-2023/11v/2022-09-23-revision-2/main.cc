#include <iostream>

using namespace std;

class Class1 {
private:
  void private_method() {
    cout << "Class1::private_method" << endl;
  }
protected:
  void protected_method() {
    cout << "Class1::protected_method" << endl;
  }
public:
  void public_method() {
    cout << "Class1::public_method" << endl;
  }
};

class Class2 : protected Class1 {
public:
  void public_method_2() {
    // private_method(); => private in the parent
    public_method();
    public_method(5);
    Class1::public_method();
    protected_method();
  }

  void public_method() {
    cout << "Class2::public_method" << endl;
  }

  void public_method(int a) {
    cout << "Class2::public_method(" << a << ")" << endl;
  }
};

class Animal {
public:
  //void move();
  virtual void move() = 0;
};

class Dog : public Animal {
public:
  void move() {
    cout << "Dog is walking" << endl;
  }
};

class Glarus : public Animal {
  int wings = 2;
public:
  void move() {
    cout << "Glarus has " << wings << " wings and is flying" << endl;
  }
};

int main() {
  //Class2 o1;

  //o1.public_method();
  //o1.public_method_2();

  //Animal a1;
  //a1.move();

  //Animal d1 = Dog();
  //d1.move();

  Animal *d1 = new Dog();
  d1->move();
  delete d1;

  d1 = new Glarus();
  d1->move();
  delete d1;

  return 0;
}