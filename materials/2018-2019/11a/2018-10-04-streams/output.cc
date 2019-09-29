#include <iostream>
#include <sstream>

using namespace std;

int main() {
    ostringstream out;
    out << "hello" << 43 << endl;

    string str = out.str();

    cout << str << endl;



    return 0;
}
