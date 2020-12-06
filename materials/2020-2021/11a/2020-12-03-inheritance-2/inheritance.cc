class A {
public:
  void method_1() {}
protected:
  void method_2() {}
private:
  void method_3() {}
};

class B : protected A {
public:
  void test() {
    method_1();
    method_2();
    //method_3();
  }
};

int main() {
  B my_test;
  my_test.method_1();
  my_test.method_2();
  //my_test.method_3();
  return 0;
}
