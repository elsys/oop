#include <iostream>

using std::cout;
using std::endl;

int main(int argc, char *argv[])
{
    #define TABLE_SIZE 10
    cout << "TABLE_SIZE value is " << TABLE_SIZE << endl;
    
    #undef TABLE_SIZE
    // here the TABLE_SIZE is undefined
    // the next line will break the compilation
    // cout << "TABLE_SIZE value is " << TABLE_SIZE;
    
    #define TABLE_SIZE 20
    cout << "TABLE_SIZE value is " << TABLE_SIZE << endl;

    #line 777 

    cout << "This is the line number " << __LINE__ << endl;
    cout << "\b of file " << __FILE__ << ".\n";
    cout << "Its compilation began " << __DATE__ << endl;
    cout << " at " << __TIME__ << ".\n";
    cout << "The compiler gives a __cplusplus value of " << __cplusplus << ".\n";
    return 0;
}
