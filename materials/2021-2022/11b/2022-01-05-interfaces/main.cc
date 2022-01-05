#include <iostream>

using namespace std;

class Class1 {
public:
  int var1 = 5;
  // virtual method meant to be overriden,  but still has a default implementation
  /*virtual void foo() {
    cout << "Class1::foo" << endl;
  }*/
  // pure virtual (abstract) method that forces children to implement it
  // having at least 1 abstract method makes the whole class abstract
  // abstract classes can never be instantiated because they do not have a complete definition
  // and that is intended
  // we want to use child classes in places that expect to receive an object, which complies with the parent class's interface
  // in Java and other OOP languages an abstract class with only abstract methods is called an interface
  virtual void foo() = 0;
};

class Class2 : public Class1 {
public:
  // the override keyword can be omitted
  void foo() override {
    cout << "Class2::foo" << endl;
  }
};

class AirAnimal {
public:
  virtual void fly() = 0;
};

class WaterAnimal {
public:
  virtual void swim() = 0;
};

class LandAnimal {
public:
  virtual void walk() = 0;
};

// tuna can swim so it implements the WaterAnimal interface/behaviour
// now we can pass an instance of Tuna to any place that expects a water animal
class TunaFish : public WaterAnimal {
public:
  void swim() {
    cout << "Tuna is swimming" << endl;
  }
};

// normally multiple inheritance is a problem BUT in this case the abstract classes are written so they don't conflict
class Duck : public WaterAnimal,
             public AirAnimal,
             public LandAnimal {
public:
  void swim() {
    cout << "Duck is swimming" << endl;
  }
  void fly() {
    cout << "Duck is flying" << endl;
  }
  void walk() {
    cout << "Duck is walking" << endl;
  }
};

void fly(AirAnimal& animal) {
  animal.fly();
}

void swim(WaterAnimal& animal) {
  animal.swim();
}

int main() {
  //Class1 c1 = (Class1)Class2();

  Class2 c2;
  Class1* c1_1 = &c2;
  Class1& c1_2 = c2;
  //c2.foo();
  //((Class1)c2).foo();
  //((Class1*)(&c2))->foo();

  TunaFish tf;
  Duck d;

  swim(tf);
  swim(d);


  return 0;
}
