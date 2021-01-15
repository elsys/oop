#include <iostream>

#include "file_copy.hh"

using namespace std;

file_copy::file_copy(int file_count, int copy_speed) : process(4), file_count(file_count), copy_speed(copy_speed) {}

int file_copy::get_time() {
  return file_count * copy_speed;
}

int file_copy::get_priority() {
  return get_time() * get_importance();
}

void file_copy::print() {
  cout << "File copy" << endl;
  cout << "File count: " << file_count << endl;
  cout << "Copy speed: " << copy_speed << endl;
  cout << "Time: " << get_time() << " Priority: " << get_priority() << endl;
}
