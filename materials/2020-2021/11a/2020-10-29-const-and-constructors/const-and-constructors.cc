#include <iostream>
using namespace std;

#define SOME_CONST 58

class my_exception : public exception {
  const char* what() {
    return "hello";
  }
};

class Computer {
public:
  const string brand = "Lenovo";
  float ram = 15;
  float hdd_size = 13;
  int* peripherals = 0;
  
  Computer() : ram(3) {
  //  this->ram = 3;
    ram = 3;
    
    peripherals = new int[5];
    for(int i=0; i < 5; i++) {
      peripherals[i] = i * 5;
    }
  }
  
  Computer(const string brand__, float ram__) : brand(brand__), ram(ram__), hdd_size(1024) {
    peripherals = new int[5];
    for(int i=0; i < 5; i++) {
      peripherals[i] = i * 5;
    }
    //this->brand = brand;
    //this->ram = ram;
    //brand__ = "hello there";
    //ram = ram__;
  }
  
  Computer(const Computer & other) : brand(other.brand), ram(other.ram), hdd_size(other.hdd_size) {
    peripherals = new int[5];
    for(int i=0; i < 5; i++) {
      peripherals[i] = other.peripherals[i];
    }
  }
  
  void print() {
    cout << brand << " " << ram  << " " << hdd_size << endl;
    for(int i=0; i< 5; i++) {
      cout << peripherals[i] << " ";
    }
    cout << endl;
  }
};

int main() {
  /*int a = 13;
  int b = 45;
  const int c = SOME_CONST;
  
  //SOME_CONST = a; // 58 = a;
  
  //c = 79;
  
  const int * ptr_to_const_1 = &c;
  int const * ptr_to_const_2 = &c;
  
  int * const const_ptr = &b;
  
  const int * const constr_ptr_to_const = &c;
  
  cout << a << " " << b << " " << c << endl;
  */
  
  /*const int a = 4;
  int const b = 6;
  
  a = 5;
  b = 7;*/
  
  Computer pc1 = Computer("Asus", 3.5);
  //pc1.ram = 3.5;
  //pc1.brand = "Asus" ;
  Computer pc2;
  
  Computer pc3 = pc1;
  //Computer pc3 = Computer(pc1);
  
  pc1.peripherals[0] = 300;
  
  Computer pc4;
  //pc4 = pc1;
  
  pc1.print();
  pc2.print();
  pc3.print();
  //cout << pc2.brand << " " << pc2.ram  << " " << pc2.hdd_size << endl;
  //cout << pc3.brand << " " << pc3.ram  << " " << pc3.hdd_size << endl;
  
  cout << &pc1  << " " << &pc2  << " " << &pc3 << endl;
  
  return 0;
}
