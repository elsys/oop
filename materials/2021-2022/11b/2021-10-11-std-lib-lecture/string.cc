#include <iostream>
#include <string>

using namespace std;

#include <string.h>
#include <stdlib.h>

int main() {
  char arr1[] = "asdf string 1";
  char arr2[] = {'a', 's' , 'd', '\0'};
  //char arr3[] = {11, 9, 63};
  //char subnet_mask[] = {255, 255, 255, 127}; // 255.255.255.127
  //char pure_white[] = {255, 255, 255}; // RGB
  
  char arr4[4];
//  arr4 = "asd";
  strcpy(arr4, "asd");
  
  char *arr5 = "asdf";
  cout << arr5 << endl;
  
  char *arr6 = (char*)malloc(4);
//  strcpy(arr6, "asd");
  memcpy(arr6, "asd", 4);
  cout << arr6 << endl;
  
  free(arr6);
  
  string str1;// = "string 1";
  str1.reserve(31);
  cout << str1.capacity() << endl;
  str1 = "string 1";
  str1 = str1 + "concat";
  str1 += "concat2";
  str1 += "1234567890";
  str1 += 'a';
  //str1.shrink_to_fit();
  //str1 -= "concat";
  cout << str1 << endl;
  
  cout << ("str1" < "str2") << endl;
  cout << str1.compare("str2") << endl;
  
  cout << str1.length() << endl;
  cout << str1.capacity() << endl;
  
  cout << str1[3] << endl;
  cout << str1.at(3) << endl;
  
  const char* arr7 = str1.c_str();
  cout << arr7 << endl;
  
  return 0;
}
