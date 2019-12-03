#include "person.hh"

Person::Person(
    std::string first_name,
    std::string last_name,
    unsigned int age)
  : first_name(first_name),
    last_name(last_name),
    age(age) {}

std::string const& Person::get_first_name() const {
  return first_name;
}

std::string const& Person::get_last_name() const {
  return last_name;
}

unsigned int Person::get_age() const {
  return age;
}

std::ostream& operator<<(
    std::ostream& os,
    Person const& person) {
  return os
    << person.get_first_name() << ", "
    << person.get_last_name() << ", "
    << person.get_age();
}
