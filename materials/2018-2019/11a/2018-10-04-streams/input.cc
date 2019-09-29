#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main() {
    string s1 = "3.14 3k";
    istringstream in(s1);

    double pi;
    in >> pi;
    if(in.good()) {
        cout << "Vsichko e tochno" << endl;
        cout << "pi=" << pi << endl;
    } else {
        cout << "Could not parse..." << endl;
    }

    int answer;
    in >> answer;
    if(!in.fail()) {
        cout << "Vsichko e tochno" << endl;
        cout << "answer=" << answer << endl;
    } else {
        cout << "Could not parse..." << endl;
    }

    string end;
    in >> end;

    cout << end << endl;

    if(in.eof()) {
        cout << "in is in EOF" << endl;
    }


    return 0;
}
