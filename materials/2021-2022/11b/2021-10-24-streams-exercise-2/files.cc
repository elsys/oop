#include <iostream>
#include <fstream>
#include <sstream>
#include <string>

using namespace std;

int main() {
  ofstream ofs("test.txt");//, ios::app);
  /*ofstream ofs = ofstream("test.txt");
  
  ofstream ofs;
  // ...
  ofs.open("test.txt");
  ofs.close();
  ofs.open....*/
  
  if(!ofs) {
    return 1;
  }
  
  ofs << "Mario" << ";" << "Benov" << ";" << 27 << endl;
  
  ofs.close();
  
  
  string firstName, lastName;
  unsigned short age;
  
  ifstream ifs("test.txt");
  //if(!ifs) {
  if(ifs.bad()) {
    return 1;
  }
  //"Mario Benov asd 27"
  //ifs >> firstName >> lastName >> age;
  //cout << ifs.good() << " " << ifs.fail() << " " << ifs.bad() << " " << ifs.eof() << endl;
  
  char line[256];
  ifs.getline(line, 255, ';');
  firstName = line;
  
  ifs.getline(line, 255, ';');
  lastName = line;
  
  ifs.getline(line, 255, ';');
  //stringstream ss(line); 
  //ss >> age;
  age = atoi(line);
  // atob btoa
  // itoa
  //Cyan
  //Magenta
  //Yellow
  //Kblack
  // ceil
  //stringstream ss(line); 
  //ss >> firstName >> lastName >> age;
  
  ifs.close();

  cout << '"' << firstName << '"'  << " \"" << lastName << "\" \"" << age << '"' << endl;
  cout << "\a";
  return 0;
}
