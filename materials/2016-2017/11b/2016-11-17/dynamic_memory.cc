#include <iostream>

using namespace std;

int main() {

    int* value = new int;
    *value = 10;

    cout << value << ": " << *value << endl;
    
    delete value;
    return 0;
}
