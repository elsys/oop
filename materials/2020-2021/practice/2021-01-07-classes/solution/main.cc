#include <list>
#include <stdlib.h>
#include <time.h>

#include "process_manager.hh"
#include "process.hh"
#include "file_copy.hh"
#include "allocate_memory.hh"

using namespace std;

int main() {
  srand (time(NULL));

  list<process*> pr;
  pr.push_back(new file_copy(10, 100));
  pr.push_back(new file_copy(30, 200));
  pr.push_back(new file_copy(150, 10));

  pr.push_back(new allocate_memory(10, 100));
  pr.push_back(new allocate_memory(80, 200));
  pr.push_back(new allocate_memory(150, 160));

  process_manager pm = process_manager(2);
  pm.add_process(pr);

  pm.print();

  return 0;
}
