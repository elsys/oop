#include <iostream>
#include <vector>

#include "database.hh"
#include "user.hh"

using namespace std;

int main () {
  //createDatabase();

  Database db;

  vector < User > found = db.findByName ("Ivan");

  for (auto it = found.begin (); it != found.end (); it++) {
    User currUser = *it;
    currUser.print ();
  }

  return 0;
}
