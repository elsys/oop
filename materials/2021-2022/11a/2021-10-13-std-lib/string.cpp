#include <iostream>
#include <string>

using namespace std;

int main()
{
    string str = "wpllo";
    cout << str << endl;
    string str2 = "World";

    // string result = str + " " + str2;
    str.append(str2);
    cout << str << endl;
    str[2] = 'e';
    cout << str[2] << endl;

    cout << (str == str2) << endl;
    cout << str.compare(str2) << endl;

    // cout << result << endl;
}