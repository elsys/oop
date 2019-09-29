#include <iostream>
#include <sstream>

using namespace std;

int main() {
    ostringstream out;
    string str = "hello world";

    out << str << 43;

    cout << out.str() << endl;



    return 0;
}
