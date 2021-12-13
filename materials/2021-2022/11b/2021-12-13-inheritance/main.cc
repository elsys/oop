#include <iostream>

using namespace std;

class Class1 {
// Accessible only to Class1 and friends
private:
  int attr1_priv = -5;
// Accessible only to Class1, friends and children
protected:
  int attr1_prot = -10;
// Accessbile to everyone
public:
  int attr1 = 5;

  Class1() {
    cout << "Class1() constructor" << endl;
  }

  Class1(int attr1) : attr1(attr1) {
    cout << "Class1(int attr1) constructor" << endl;
  }

  void foo1() {
    cout << "Class1::foo1" << endl;
  }
};

class Class3 {
public:
  int attr1 = 15;

  void foo1() {
    cout << "Class3::foo1" << endl;
  }
};

// Access modifier can reduce the level of access when inheriting. It CANNOT increase the level of access
// public keeps public things as public
// protected turns public things to protected
// private turns public and protected things to private
class Class2 : private Class1, public Class3 {
public:
  int attr2 = 10;

  Class2() {
    cout << "Class2 constructor" << endl;
  }

  // You can call a parent's constructor in the initializer list
  // Normally constructors should only initialize things defined in their own class
  Class2(int attr1, int attr2) : Class1(attr1), attr2(attr2) {
    cout << "Class2(int attr1, int attr2) constructor" << endl;
  }

  // Override the inherited method
  void foo1() {
    cout << "Class2::foo1" << endl;
    // Use parent::thing when you want to explicitly access a parent's thing or when inheriting same things from multiple parents
    Class1::foo1();
    Class3::foo1();
  }

  void foo2() {
    //cout << "Class2::foo2" << endl;
    //Class1::foo1();
    //foo1();
    // You can access public and protected things from the parent
    cout <<
      Class1::attr1 << " " <<
      attr1_prot << endl;
      //attr1_priv << endl;
  }
};

int main() {
  Class1 c1 = Class1();
  cout << c1.attr1 << endl;
  c1.foo1();

  cout << endl;

  Class2 c2 = Class2();
  cout << c2.Class3::attr1 << " " << c2.attr2 << endl;
  //c2.foo1();
  c2.foo2();
  //((Class1)c2).foo1();
  //((Class2)((Class1)c2)).foo1();
  //((Class2)((Class1)c2)).foo2();

  Class2 c3 = Class2(25, 35);
  cout << c3.Class1::attr1 << " " << c3.attr2 << endl;

  return 0;
}
