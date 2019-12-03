#ifndef PERSON_HH
#define PERSON_HH

#include <string>
#include <iostream>

class Person {
  std::string first_name;
  std::string last_name;
  unsigned int age;

public:
  Person(
      std::string first_name,
      std::string last_name,
      unsigned int age);

  std::string const& get_first_name() const;
  std::string const& get_last_name() const;
  unsigned int get_age() const;
};

std::ostream& operator<<(
    std::ostream& os,
    Person const& person);

#endif
