#include <iostream>
#include <string>
#include <stack>

bool is_opening(char c) {
  return c == '(' ||
    c == '[' ||
    c == '{';
}

bool is_closing(char c) {
  return c == ')' ||
    c == ']' ||
    c == '}';
}

bool are_matching(char opening_bracket, char closing_bracket) {
  return opening_bracket == '(' && closing_bracket == ')' ||
    opening_bracket == '[' && closing_bracket == ']' ||
    opening_bracket == '{' && closing_bracket == '}';
}

bool is_balanced(std::string str) {
  std::stack<char> s;

  for (int i = 0; i < str.length(); ++i) {
    char current = str[i];
    if (is_opening(current)) {
      s.push(current);
    } else if (is_closing(current)) {
      if (s.empty()) {
        return false;
      } else if (!are_matching(s.top(), current)) {
        return false;
      }
      s.pop();
    }
  }

  return s.empty();
}

int main() {
  std::string input;
  std::cin >> input;
  std::cout << is_balanced(input) << '\n';

  return 0;
}
