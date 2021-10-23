#include <string>
#include <iostream>

#include "user.hh"

using namespace std;

User::User (string name, string email, unsigned short age, string password) {
  this->name = name;
  this->email = email;
  this->age = age;
  this->password = password;
}

void User::print () {
  cout << name << "(" << age << ") " << email << " " << password << endl;
}
