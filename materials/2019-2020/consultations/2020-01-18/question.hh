#ifndef QUESTION_HH
#define QUESTION_HH

#include <string>

class Question {
  std::string text;
  double points;

public:
  Question(std::string const& text, double points);

  virtual Question* clone() const = 0;

  virtual void ask() = 0;

  virtual double grade() = 0;

  std::string const& get_text() const;

  double get_points() const;
};

#endif
