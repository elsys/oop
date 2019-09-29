#include <sstream>
#include <iostream>

using namespace std;

int main() {
    string str = "3k 42";
    istringstream in(str);

    // int pi;
    // in >> pi;
    // if(!in.fail() && !in.bad()) {
    //     cout << "Vsichko e tochno" << endl;
    //     cout << "pi=" << pi << endl;
    // } else {
    //     cout << "Could not parse" << endl;
    // }
    string str1;
    in >> str1;

    while(!in.eof()) {
        cout << "Parsed string=" << str << endl;
        in >> str1;
    }

    cout << "Reached EOF" << endl;
}
