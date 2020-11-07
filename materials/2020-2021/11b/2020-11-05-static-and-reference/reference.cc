#include <iostream>
#include <list>

using namespace std;
/*
void swap(int *a, int *b) {
  *a = *a + *b;
  *b = *a - *b;
  *a = *a - *b;
  
  cout << *a << " " << *b << endl;
}*/

void swap(int &a, int &b) {
  cout  << &a << endl;
  a = a + b;
  b = a - b;
  a = a - b;
  
  cout << a << " " << b << endl;
}

class House {
  unsigned int pet_count;
  unsigned int room_count;
  list<int> people;
public:
  House(unsigned int pet_count, unsigned int room_count) : pet_count(pet_count), room_count(room_count) {}
  
  House(const House& house) {
    cout << "copy constructor called" << endl;
  }
  
  static void print(const House& house) {
    //house.pet_count = 15;
    cout << house.pet_count << " " << house.room_count << " " << house.people.size() << endl;
  }
  
  unsigned int get_pet_count() { return pet_count; }
};

int main() {
  int a = 4;
  int b = 19;
  
  int *p = &a;
  int &r = a;
  
  cout << &r << " " << &a << endl;
  
  swap(a, b);
  
  cout << a << " " << b << endl;
  
  House h1 = House(3, 2);
  House::print(h1);
  
  cout << h1.get_pet_count() << endl;
  
  return 0;
}
