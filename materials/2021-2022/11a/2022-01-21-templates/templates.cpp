#include "Stack.cpp"
#include <iostream>

using namespace std;

// int Max(const int &a, const int &b) { return a > b ? a : b; }

// double Max(const double &a, const double &b) { return a > b ? a : b; }

// template<class T, class R, class V....>
template <class T> T Max(const T &a, const T &b) { return a > b ? a : b; }

template <class T> T Min(const T &a, const T &b) { return a < b ? a : b; }

template <class T, bool min_max> T compare(const T &a, const T &b) {
  if (min_max) {
    return a < b ? a : b;
  } else {
    return a > b ? a : b;
  }
}

template <bool min_max, class T> T comp(const T &a, const T &b) {
  if (min_max) {
    return a < b ? a : b;
  } else {
    return a > b ? a : b;
  }
}

int main() {
  int a = 4;
  int b = 5;

  cout << Max(a, b) << endl;

  double c = 2.5;
  double d = 3.6;

  cout << Max<double>(c, d) << endl;

  cout << Min(c, d) << endl;

  cout << compare<double, true>(c, d) << endl;
  cout << compare<double, false>(c, d) << endl;
  //   cout << compare<false>(c, d) << endl;

  cout << comp<false>(c, d) << endl;

  Stack<int> s;
  s.push(2);
  s.push(3);
  s.push(4);

  for (int i = 0; i < 10; i++) {
    cout << s.pop() << endl;
  }
}