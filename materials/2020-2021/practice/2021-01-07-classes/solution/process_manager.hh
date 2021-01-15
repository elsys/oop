#ifndef PROCESS_MANAGER_HH
#define PROCESS_MANAGER_HH

#include <list>
#include <queue>

#include "process.hh"

using namespace std;

class process_manager {
  list<queue<process*>> threads;

  queue<process*>& find_free_thread(process* pr);
  int sum_priority(queue<process*>& thread);
public:
  process_manager(int thread_count);

  void add_process(list<process*> processes);

  void print();
};

#endif
