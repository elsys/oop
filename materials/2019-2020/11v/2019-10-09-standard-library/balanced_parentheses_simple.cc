#include <iostream>
#include <string>

bool is_balanced(std::string str) {
  int count = 0;

  for (int i = 0; i < str.length(); ++i) {
    char current = str[i];
    if (current == '(') {
      ++count;
    } else if (current == ')') {
      if (count == 0) {
        return false;
      }
      --count;
    }
  }

  return count == 0;
}

int main() {
  std::string input;
  std::cin >> input;
  std::cout << is_balanced(input) << '\n';

  return 0;
}
