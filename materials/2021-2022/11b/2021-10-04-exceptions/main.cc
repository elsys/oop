#include <iostream>
#include <string>
#include "list.hh"

using namespace std;

int main() {
  List my_list;
  
  /*my_list.push(4);
  my_list.push(8);
  my_list.push(-2);
  
  my_list.print();*/

  cout << "before try" << endl;  
  try {
    cout << my_list.get_at(15) << endl;
  } catch(int ex) {
    cout << "exception int caught: " << ex << endl;
  } catch(char const* ex) {
    cout << "exception string caught: " << ex << endl;
  //} catch(string ex) {
  //  cout << "exception string caught: " << ex << endl;
  } catch(my_ex& ex) {
    cout << "exception exception caught: " << ex.what() << endl;
  }
  cout << "after try" << endl;
  
  return 0;
}
