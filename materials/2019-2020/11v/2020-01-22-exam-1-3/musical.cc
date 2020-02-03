#include "musical.hh"
#include <iostream>

Musical::Musical(std::string const& title): title(title) {}

Musical::Musical(Musical const& other): title(other.title) {
  for (auto iter = other.actions.begin(); iter != other.actions.end(); ++iter) {
    add_action(*iter);
  }
}

Musical& Musical::operator=(Musical const& other) {
  if (this == &other) {
    return *this;
  }

  for (auto iter = actions.begin(); iter != actions.end(); ++iter) {
    delete *iter;
  }
  for (auto iter = other.actions.begin(); iter != other.actions.end(); ++iter) {
    add_action(*iter);
  }

  return *this;
}

Musical::~Musical() {
  for (auto iter = actions.begin(); iter != actions.end(); ++iter) {
    delete *iter;
  }
}

std::vector<Action*>::const_iterator Musical::find_action(
    unsigned int number) const {
  auto iter = actions.begin();
  for (; iter != actions.end(); ++iter) {
    if ((*iter)->get_number() == number) {
      return iter;
    }
  }
  return iter;
}

bool Musical::has_missing_actions() const {
  for (int i = 0; i < actions.size(); ++i) {
    if (actions[i]->get_number() != i + 1) {
      return true;
    }
  }
  return false;
}

void Musical::add_action(Action const* action) {
  if (find_action(action->get_number()) != actions.end()) {
    throw ActionAlreadyExistsError();
  }

  actions.push_back(action->clone());
}

void Musical::print() const {
  std::cout << title;
  if (!actions.empty()) {
    std::cout << '\n';
  }
  for (auto iter = actions.begin(); iter != actions.end(); ++iter) {
    (*iter)->print();
    if (iter + 1 != actions.end()) {
      std::cout << '\n';
    }
  }
}

Action const* Musical::most_crowded_action() const {
  if (actions.empty()) {
    throw NoActionsError();
  }

  auto result = actions.begin();
  for (auto iter = actions.begin() + 1; iter != actions.end(); ++iter) {
    if ((*iter)->get_actors().size() > (*result)->get_actors().size()) {
      result = iter;
    }
  }
  return *result;
}

void Musical::sort() {
  for (auto i = actions.begin(); i != actions.end(); ++i) {
    auto min = i;
    for (auto j = actions.begin() + 1; j != actions.end(); ++j) {
      if ((*j)->get_number() < (*min)->get_number()) {
        min = j;
      }
    }
    if (min != i) {
      Action* temp = *i;
      *i = *min;
      *min = temp;
    }
  }

  if (has_missing_actions()) {
    throw MissingActionsError();
  }
}
