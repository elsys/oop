#include <iostream>
#include <fstream>

using namespace std;
/*
c = a / b
a << 3
a = ~b

a += b => a = a + b
a = &b
a = *b

most of the operators in c++:
+ -
+ - * / %
<< >> & | ^ ~
/= *= -= += =
< > == >= <= !=
++ -- ++ --
. -> ... , & *
?:
[] ()
&& || !
*/

class Test {
  int a;
  //static int setCounter = 0;
public:
  /*void setA(int aa) {
    if(aa > 200) throw exception();
    setCounter++;
    a = aa;
  }*/

  Test() : Test(2) {}
  Test(int a) : a(a) {}

  int getA() const {
    return a;
  }

  // override unary + and modify it to always turn a into a positive number
  Test operator+() const {
    Test result(this->a);
    if(result.a < 0) result.a *= -1;

    return result;
  }

  // override the stream output operator as a friend to give it access to a
  friend ostream& operator<<(ostream& out, const Test& arg) {
    out << arg.a << " ";
    return out;
  }

  // override the [] operator to return the n-th bit left-to-right
  bool operator[](unsigned char index) const {
    int mask = 1 << (32 - index);
    //return (a & mask) >> (32 - index);
    return (a & mask) > 0;
  }
  //0b010101110101001010101010100101
  // &
  //0b000000100000000000000000000000
  // ==
  //0b000000100000000000000000000000
  // shift to the right
  //0b000000000000000000000000000001
};
// can define operators outside the class like global functions
/*
Test operator+(const Test & arg) {
  Test result(arg.a);
  if(result.a < 0) result.a *= -1;

  return result;
}*/

int main() {
  Test t1(5); // 0b101
  Test t2(-3);

  // use the operator which will implicitly call the overloaded method
  Test t3 = +t1;
  //Test t4 = +t2;
  // explicitly call the operator method
  Test t4 = t2.operator+();

  cout << "t1 " << t1 << endl;
  cout << "t2 " << t2.getA() << endl;
  cout << "t3 " << t3.getA() << endl;
  cout << "t4 " << t4.getA() << endl;

  ofstream ofs("test.txt");
  // Test::operator<< does not care what the output stream is
  ofs << t1 << endl;
  ofs.close();

  cout << t1[30] << " " << t1[31] << " " << t1[32] << endl;

  /*y = ax + b
  Line l1(a = 3, b = 5)
  l1(x = 7) => 26*/

  //t1.operator<<(cout);
  /*cout.operator<<(
    "t1 ".operator<<(
      t1.getA().operator<<(endl)
    )
  );*/

  return 0;
}
