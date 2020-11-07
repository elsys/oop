#include <iostream>
#include <list>

using namespace std;

//int counter = 0;
int do_some_work() {
  static int counter = 0;
  
  cout << "Bying bread..." << endl;
  counter++;
  
  return counter;
}

class Human {
public:
  string name;
};

class House {
  unsigned int pet_count;
  unsigned int room_count;
  list<Human> people;
public:
  static int instance_count;
  
  House(unsigned int pet_count, unsigned int room_count) : pet_count(pet_count), room_count(room_count) {
    instance_count++;
  }
  
  static void print(House house) {
    cout << house.pet_count << " " << house.room_count << " " << house.people.size() << endl;
  }
};

class Math {
  Math() {}
public:
  static int add(int a, int b) {
    return a + b;
  }
};

namespace Math_v2 {
  int add(int a, int b) {
    return a + b;
  }
}

int House::instance_count = 0;

int main() {
  int count = 0;
  
  count = do_some_work();
  //count++;
  count = do_some_work();
  //count++;
  count = do_some_work();
  //count++;
  
  cout << count << endl;
  
  House h1 = House(3, 2);
  House::print(h1);
  
  cout << House::instance_count << endl;
  
  cout << Math   ::add(3, 9) << endl;
  cout << Math_v2::add(3, 9) << endl;
  //Math m1;
  
  return 0;
}
