#ifndef DATABASE_HH
#define DATABASE_HH

#include <string>
#include <vector>

#include "user.hh"

using namespace std;

class Database {
  string filename = "users.txt";
public:
  vector<User> findByName(string nameToFind);
};

void createDatabase();

#endif
