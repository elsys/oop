#include <iostream>
#include <sstream>

int main() {
  std::string input = "3.14 42k";

  std::istringstream iss(input);

  double pi;
  iss >> pi;
  if (iss.good()) {
    std::cout << pi << '\n';
  }

  int answer;
  iss >> answer;

  if (!iss.fail()) {
    std::cout << answer << '\n';
  }

  std::string end;
  iss >> end;
  std::cout << end << '\n';

  if (iss.eof()) {
    std::cout << "End of file is reached\n";
  }

  iss >> end;
  if (iss.bad()) {
    std::cout << "bad\n";
  }
  if (iss.fail()) {
    std::cout << "fail\n";
  }

  std::ostringstream oss;
  oss << 1 << 2 << "three";
  std::cout << oss.str() << '\n';

  return 0;
}
