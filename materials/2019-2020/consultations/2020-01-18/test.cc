#include "test.hh"

Test::Test() {}

Test::Test(Test const& other) {
  for (auto iter = other.questions.begin();
      iter != other.questions.end();
      ++iter) {
    add_question(*iter);
  }
}

Test& Test::operator=(Test const& other) {
  if (this == &other) {
    return *this;
  }

  for (auto iter = questions.begin(); iter != questions.end(); ++iter) {
    delete *iter;
  }
  for (auto iter = other.questions.begin();
      iter != other.questions.end();
      ++iter) {
    add_question(*iter);
  }

  return *this;
}

Test::~Test() {
  for (auto iter = questions.begin(); iter != questions.end(); ++iter) {
    delete *iter;
  }
}

void Test::add_question(Question const* question) {
  questions.push_back(question->clone());
}

void Test::do_test() {
  for (auto iter = questions.begin(); iter != questions.end(); ++iter) {
    (*iter)->ask();
  }
}

double Test::grade_test() {
  double total_points = 0;
  for (auto iter = questions.begin(); iter != questions.end(); ++iter) {
    total_points += (*iter)->grade();
  }
  return total_points;
}
