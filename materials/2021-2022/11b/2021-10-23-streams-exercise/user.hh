#ifndef USER_HH
#define USER_HH

#include <string>

using namespace std;

class User {
public:
  string name;
  string email;
  unsigned short age;
  string password;

  User (string name, string email, unsigned short age, string password);

  void print ();
};

#endif
