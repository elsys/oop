#include <iostream>

#include "process_manager.hh"

process_manager::process_manager(int thread_count) {
  threads = list<queue<process*>>();
  for(int i=0; i<thread_count; i++) {
    threads.push_back(queue<process*>());
  }
}

int process_manager::sum_priority(queue<process*>& thread) {
  int sum = 0;
  queue<process*> tmp = thread;
  while(tmp.size()) {
    process* pr = tmp.front();
    tmp.pop();
    sum += pr->get_priority();
  }
  return sum;
}

queue<process*>& process_manager::find_free_thread(process* pr) {
  queue<process*>* found = &(threads.front());

  for(auto it = threads.begin(); it != threads.end(); it++) {
    queue<process*>* thread = &(*it);
    if(sum_priority(*thread) < sum_priority(*found)) {
      found = thread;
    }
  }

  return *found;
}

void process_manager::add_process(list<process*> processes) {
  for(auto it = processes.begin(); it != processes.end(); it++) {
    process* pr = *it;
    queue<process*>& thread = find_free_thread(pr);
    thread.push(pr);
  }
}

void process_manager::print() {
  int thread_num = 0;
  for(auto it_t = threads.begin(); it_t != threads.end(); it_t++) {
    cout << "Thread: " << thread_num++ << endl;
    queue<process*> thread = *it_t;

    int process_num = 0;
    while(thread.size()) {
      process* pr = thread.front();
      thread.pop();
      cout << "\tProcess: " << process_num++ << endl;
      pr->print();
    }
  }
}
