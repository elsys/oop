#include <iostream>
#include <sstream>

int main() {
  // for (int n; std::cin >> n;) {
  //   if (std::cin.fail()) {
  //     std::cout << "failure\n";
  //   }
  //   std::cout << n << '\n';
  // }

  std::istringstream iss("3.14 \t  5.01 tues 434f");

  double pi;
  iss >> pi;
  std::cout << pi << '\n';

  double x;
  iss >> x;
  std::cout << x << '\n';

  std::string str = "elsys";
  iss >> str;
  if (iss) {
    std::cout << str << '\n';
  } else {
    std::cout << "failure\n";
  }

  char c;
  iss.get(c);
  std::cout << c << '\n';

  iss.get(c);
  std::cout << c << '\n';

  std::cout << (char)iss.peek() << '\n';

  std::string input;
  std::cin >> input;
  std::istringstream is(input);

  // char name[100];
  // char fn[100];
  // char grade[100];
  // is.getline(name, 100, ',')
  //   .getline(fn, 100, ',')
  //   .getline(grade, 100, ',');
  // std::cout << name << '\n' << fn << '\n' << grade << '\n';

  std::string name;
  std::string fn;
  std::string grade;
  std::getline(is, name, ',');
  std::getline(is, fn, ',');
  std::getline(is, grade, ',');
  std::cout << name << '\n' << fn << '\n' << grade << '\n';

  std::stringstream ss;
  ss << fn << ' ' << grade;
  std::cout << ss.str() << '\n';

  int fn_number;
  int grade_number;
  ss >> fn_number >> grade_number;

  std::cout << fn_number << '\n' << grade_number << '\n';

  return 0;
}
