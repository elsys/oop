#ifndef YES_NO_QUESTION_HH
#define YES_NO_QUESTION_HH

#include "question.hh"

class YesNoQuestion : public Question {
  bool isYes;
  bool answer;

public:
  YesNoQuestion(std::string const& text, double points, bool isYes);

  Question* clone() const;

  void ask();

  double grade();
};

#endif
