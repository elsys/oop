#include <iostream>
#include <list>

using namespace std;

void swap(int &a, int &b) {
  int c = a;
  a = b;
  b = c;
}

class Student {
  const string name;
  short _class;
  list<float> grades;
public:
  Student(string name, short _class) : name(name), _class(_class) {}
  Student(const Student& s) {
    cout << "copy constructor called" << endl;
  }
  
  short getClass() { return _class; }
  
  static void print(const Student& s) {
    //s._class = 10;
    cout << s.name << " " << s._class << " " << s.grades.size() << endl;
  }
};

int main() {
  int a = 5;
  int b = 7;
  
  int &h = a;
  int *p = &a;
  
  swap(a, b);
  
  cout << a << " " << b << endl;
  
  Student s = Student("Pesho", 4);
  
  Student::print(s);
  cout << s.getClass() << endl;
  
  return 0;
}
