#ifndef OPEN_QUESTION_HH
#define OPEN_QUESTION_HH

#include "question.hh"

class OpenQuestion : public Question {
  std::string answer;

public:
  OpenQuestion(std::string const& text, double points);

  Question* clone() const;

  void ask();

  double grade();
};

#endif
