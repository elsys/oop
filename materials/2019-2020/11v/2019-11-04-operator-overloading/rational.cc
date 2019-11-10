#include <cstdlib>
#include <iostream>

class Rational {
  long numerator;
  long denominator;

  static long gcd(long x, long y) {
    while (x != y) {
      if (x > y) {
        x -= y;
      } else {
        y -= x;
      }
    }

    return x;
  }

  void reduce() {
    if (numerator == 0) {
      denominator = 1;
    } else {
      long divisor = gcd(std::labs(numerator), denominator);
      numerator /= divisor;
      denominator /= divisor;
    }
  }

  void standardize() {
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    reduce();
  }

public:
  class ZeroDenominatorError {};

  Rational(long numerator, long denominator)
    : numerator(numerator), denominator(denominator) {
    if (denominator == 0) {
      throw ZeroDenominatorError();
    }

    standardize();
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

  Rational operator+(Rational const& other) const {
    long numerator =
      get_numerator() * other.get_denominator() +
      other.get_numerator() * get_denominator();
    long denominator = get_denominator() * other.get_denominator();

    return Rational(numerator, denominator);
  }

  Rational& operator+=(Rational const& other) {
    return *this = *this + other;
  }

  Rational operator-(Rational const& other) const {
    return *this + -other;
  }

  Rational& operator-=(Rational const& other) {
    return *this = *this - other;
  }

  Rational operator*(Rational const& other) const {
    long numerator = get_numerator() * other.get_numerator();
    long denominator = get_denominator() * other.get_denominator();

    return Rational(numerator, denominator);
  }

  Rational& operator*=(Rational const& other) {
    return *this = *this * other;
  }

  Rational operator/(Rational const& other) const {
    return *this * other.reciprocal();
  }

  Rational& operator/=(Rational const& other) {
    return *this = *this / other;
  }

  operator double() const {
    return (double)get_numerator() / get_denominator();
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

  Rational r(2, 3);
  Rational rr = r.reciprocal();

  std::cout << rr << '\n'; // <=> operator<<(operator<<(std::cout, rr), '\n');
  std::cout << -rr << '\n'; // <=> std::cout << rr.operator-() << '\n';

  std::cout << r + rr << '\n';
  std::cout << r * rr << '\n';

  (r += rr) += Rational(3, 4);
  std::cout << r << '\n';

  std::cout << (double)r << '\n';

  return 0;
}
