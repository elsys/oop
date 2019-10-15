#include <iostream>
#include <string>
#include <stack>

bool is_balanced(std::string str) {
  std::stack<char> s;

  for (int i = 0; i < str.length(); ++i) {
    char current = str[i];
    if (current == '(') {
      s.push(current);
    } else if (current == ')') {
      if (s.empty()) {
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
