#include <iostream>

#include "allocate_memory.hh"

using namespace std;

allocate_memory::allocate_memory(int required_size, int total_size) : process(7), required_size(required_size), total_size(total_size) {
  first_rand = 100 + (rand() % 900 );
  second_rand = 10 + (rand() % 10 );
}

int allocate_memory::get_time() {
  return ((float)required_size / total_size) * first_rand;
}

int allocate_memory::get_priority() {
  return get_time() * get_importance() * second_rand;
}

void allocate_memory::print() {
  cout << "Allocate memory" << endl;
  cout << "Required: " << required_size << endl;
  cout << "Total: " << total_size << endl;
  cout << "Time: " << get_time() << " Priority: " << get_priority() << endl;
}
