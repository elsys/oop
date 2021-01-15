#include "process.hh"

process::process(int importance) : importance(importance) {}

int process::get_importance() {
  return importance;
}
