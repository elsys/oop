#include <iostream>
#include <string>

#include "GC.hh"
#include "BaseObject.hh"

using namespace std;

class DemoClass : public BaseObject {
public:
  int val1 = 10;
  float val2[2] = {3, 5};
};

int main()
{
  GC::init();

  try {
    int* test1 = (int*)GC::allocate(sizeof(int)); // Allocate a single int
    GC::dump_all("dump_1.txt");
    int* test2 = (int*)GC::allocate(sizeof(int) * 5); // Allocate 5 ints after test1
    GC::dump_all("dump_2.txt");
    DemoClass* test3 = new DemoClass(); // Use the overloaded operator new
    GC::dump_all("dump_3.txt");
    DemoClass* test4 = new DemoClass[5]; // Use the overloaded operator new[]
    GC::dump_all("dump_4.txt");

    GC::free(test2); // Free a hole of 20 bytes
    GC::dump_all("dump_5.txt");
    GC::grow(test1, sizeof(int) * 4); // Grow test1 in the hole from test2
    GC::dump_all("dump_6.txt");
    GC::shrink(test4, sizeof(DemoClass) * 3); // Reduce the block for test4
    GC::dump_all("dump_7.txt");
    delete test3; // Make a new hole
    GC::dump_all("dump_8.txt");
    GC::grow(test1, sizeof(int) * 20); // Should fail because there aren't enough free bytes after test1
    GC::dump_all("dump_9.txt");
  } catch(GC::InvalidSizeException& ex) {
    cout << "Invalid size: " << ex.what() << endl;
  } catch(bad_alloc& ex) {
    cout << "Bad allocation: " << ex.what() << endl;
  } catch(system_error& ex) {
    cout << "System error: " << ex.what() << endl;
  }

  GC::clear();

  return 0;
}
