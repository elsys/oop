#include <iostream>
using namespace std;

class Fib {
  int *nums;
  
  void copy(const Fib& other) {
    num0 = other.num0;
    num1 = other.num1;
    size = other.size;
    
    nums = new int[size];
    for(int i=0; i < size; i++) {
      nums[i] = other.nums[i];
    }
  }
public:
  int num0;
  int num1;
  int size;
  
  Fib() : num0(0), num1(1), size(2) {
    nums = new int[size];
    generate();
  }
  
  Fib(int size) : num0(0), num1(1), size(size) {
    nums = new int[size];
    generate();
  }

  Fib(int size, int num0, int num1) : num0(num0), num1(num1), size(size) {
    nums = new int[size];
    generate();
  }
  
  Fib(const Fib& other) {
    copy(other);
  }
  
  void  operator=(const Fib& other) {
    copy(other);
  }
  
  void generate() {
    nums[0] = num0;
    nums[1] = num1;
    
    for(int i = 2; i < size; i++) {
      nums[i] = nums[i - 1] + nums[i - 2];
    }
  }
  
  friend ostream& operator<<(ostream& os, const Fib& fib);
};

ostream& operator<<(ostream& os, const Fib& fib) {
  os << "(" << fib.size << ") ";
  for(int i = 0; i < fib.size; i++) {
    os << fib.nums[i] << " ";
  }
  return os;  
}

int main() {
  Fib f1(5, 0, 1);
  Fib f2 = f1;
  Fib f3;
  f3 = f1;
 
  f1.num0 = 5;
  f1.num1 = 10;
  f1.generate();
  
  cout << f1 << endl; 
  cout << f2 << endl;
  cout << f3 << endl;
  
  return 0;
}
