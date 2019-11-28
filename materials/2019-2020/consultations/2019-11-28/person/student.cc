#include "student.hh"

Student::Student(
    std::string first_name,
    std::string last_name,
    unsigned int age,
    std::string speciality,
    double grade)
  : Person(first_name, last_name, age),
    speciality(speciality),
    grade(grade) {}

std::string const& Student::get_speciality() const {
  return speciality;
}

double Student::get_grade() const {
  return grade;
}

std::ostream& operator<<(
    std::ostream& os,
    Student const& student) {
  return os
    << (Person)student << ", "
    << student.get_speciality() << ", "
    << student.get_grade();
}
