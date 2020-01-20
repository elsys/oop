#include "question.hh"

Question::Question(std::string const& text, double points)
  : text(text), points(points) {}

std::string const& Question::get_text() const {
  return text;
}

double Question::get_points() const {
  return points;
}
