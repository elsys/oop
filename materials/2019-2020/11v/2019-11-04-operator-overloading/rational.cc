#include <iostream>

class Rational {
  long numerator;
  long denominator;

public:
  class ZeroDenominatorError {};

  Rational(long numerator, long denominator)
    : numerator(numerator), denominator(denominator) {
    if (denominator == 0) {
      throw ZeroDenominatorError();
    }
  }

  long get_numerator() const  {
    return numerator;
  }

  long get_denominator() const {
    return denominator;
  }

  Rational reciprocal() const {
    return Rational(get_denominator(), get_numerator());
  }

  Rational operator-() const {
    return Rational(-get_numerator(), get_denominator());
  }
};

std::ostream& operator<<(std::ostream& os, Rational const& r) {
  return os
    << r.get_numerator()
    << '/'
    << r.get_denominator();
}

int main() {
  try {
    Rational r(1, 0);
  } catch (Rational::ZeroDenominatorError) {
    std::cout << "Zero denominator\n";
  }

  Rational const r(2, 3);
  Rational const rr = r.reciprocal();

  std::cout << rr << '\n'; // <=> operator<<(operator<<(std::cout, rr), '\n');
  std::cout << -rr << '\n'; // <=> std::cout << rr.operator-() << '\n';

  return 0;
}
