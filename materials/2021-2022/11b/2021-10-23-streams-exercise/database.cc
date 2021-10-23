#include <iostream>
#include <sstream>
#include <fstream>
#include <queue>
#include <string.h>

#include "database.hh"
#include "user.hh"

using namespace std;

vector <User> Database::findByName (string nameToFind) {
  ifstream ifs = ifstream (filename);

  if (!ifs) {
    throw system_error ();
  }

  cout << "Reading from " << filename << endl;

  queue < User > buffer;
  vector < User > result;

  while (!ifs.eof ()) {
    char line[256];
    ifs.getline (line, 255);

    if (strlen (line) > 0) {
	  string name;
	  string email;
	  unsigned short age;
	  string password;

	  stringstream ss(line);
	  ss >> name >> email >> age >> password;

	  User newUser = User (name, email, age, password);
	  buffer.push (newUser);
	}

    if (buffer.size () >= 5 || ifs.eof ()) {
	  cout << "Read " << buffer.size () << " records" << endl;
	  while (buffer.size () > 0) {
        User currUser = buffer.front ();
	    buffer.pop ();

	    if (currUser.name == nameToFind)
		  result.push_back (currUser);
	  }
	}
  }

  ifs.close ();
  cout << "Found " << result.size () << " matches" << endl;

  return result;
}

void createDatabase () {
  cout << "Creating database." << endl;
  ofstream
  ofs ("users.txt");
  if (!ofs)
    throw system_error ();

  queue < User > users;

  users.push (User ("Ivan", "ivan1@mail.com", 25, "1234"));
  users.push (User ("Petar", "petar1@mail.com", 15, "4321"));
  users.push (User ("Ivan", "ivan2@mail.com", 35, "qwer"));
  users.push (User ("Stoyan", "stoyan1@mail.com", 45, "rewq"));
  users.push (User ("Martin", "martin1@mail.com", 25, "12qw"));
  users.push (User ("Ivan", "ivan3@mail.com", 15, "wq21"));

  while (users.size () > 0) {
    User user = users.front ();
    users.pop ();

    ofs << user.name << " " << user.email << " " << user.age << " " << user.
	password << endl;
  }

  ofs.close ();
  cout << "Database created." << endl;
}
