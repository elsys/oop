Order o1(15, 5;) // parts, days
Order o2(75, 4);
      o3(20, 7);

#include <fstream>
#include <stringstream>
using namespace std;

string var1;
string var2;

sstream ss = sstream("asddas asd asd");
ss >> var1 >> var2;

ifstream ifs = ifstream("test.txt");
ofstream ofs = ofstream("test.txt", ios::app);
if(!ofs) {
  throw ...
}

ofs.good()
ofs.fail()
ofs.bad()
ofs.eof()

cin >> var1 >> var2;
ofs >> var1 >> var2 >> var3;

ofs.close()

class my_exception : public exception {
  const char* what() {
    return "file not found";
  }
}

*it -> current
*(it++) -> next

vector<int> vec;
vec[3] = 15;


Order ord1;
