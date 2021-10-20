#include <iostream>
#include <fstream>
#include <iomanip>
#include <sstream>

using namespace std;

int main() {
  /*read(...)
  getchar()
  gets()
  scanf()
  
  fopen()
  fclose()
  fread()
  fgetchar()
  fgets()
  fscanf()*/
  
//  ofstream ofs = ofstream("test.txt");
//  ofstream ofs("test.txt");
  ofstream ofs;
  ofs.open("test.txt");
  
  //if(ofs.is_open()) {
  //if(ofs.good()) {
  if(ofs) {
    ofs << "HELLO" << endl;
    ofs.write("WORLD\n", 6);
    //ofs.write(1234, 4);
    
    ofs << setfill('~') << fixed << setprecision(7) << setw(5) << 167.25 << setbase(16) << setw(5) << 15 << setw(5) << 3.2 << endl;
    
    ofs << setbase(10) << scientific << setprecision(4) << 1000000000001.0 << endl;
  
    ofs.close();
  }
  
  stringstream ss("1 2 3");
  int a, b, c;
  //ss >> a << 7 >> b >> c << "wtf";
  ss >> a >> b >> c;
  
  cout << a << " " << b << " "  << c << endl;

  return 0;
}





