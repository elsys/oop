#ifndef STUDENT_HH
#define STUDENT_HH

#include "person.hh"
#include <string>
#include <iostream>

class Student : public Person {
  std::string speciality;
  double grade;

public:
  Student(
      std::string first_name,
      std::string last_name,
      unsigned int age,
      std::string speciality,
      double grade);

  std::string const& get_speciality() const;
  double get_grade() const;
};

std::ostream& operator<<(
    std::ostream& os,
    Student const& student);

#endif
