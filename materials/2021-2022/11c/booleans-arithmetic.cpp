#include <iostream>

using std::cout;

int main(int argc, char *argv[])
{
    bool a = false;
    bool b = true;
    
    bool result;
    
    // https://en.wikipedia.org/wiki/De_Morgan%27s_laws
    result = !(a || b);
    cout << "!(a || b) = " << result << "\n";

    result = !a && !b;
    cout << "!a && !b  = " << result << "\n";
    
    cout << "and\n";
    
    result = !(a && b);
    cout << "!(a && b) = " << result << "\n";

    result = !a && !b;
    cout << "!a || !b  = " << result << "\n";
}
