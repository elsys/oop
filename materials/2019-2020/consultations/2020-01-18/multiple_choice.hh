#ifndef MULTIPLE_CHOICE_HH
#define MULTIPLE_CHOICE_HH

#include "question.hh"
#include <vector>

class MultipleChoice : public Question {
  std::vector<std::string> answers;
  std::vector<unsigned int> true_answers;
  std::vector<unsigned int> user_answers;

public:
  MultipleChoice(
      std::string const& text,
      double points,
      std::vector<std::string> const& answers,
      std::vector<unsigned int> const& true_answers);

  Question* clone() const;

  void ask();

  double grade();
};

#endif
