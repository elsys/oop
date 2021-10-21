#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main()
{
    // cout << "Enter name: " << endl;
    // string name;
    // // cin >> name;
    // // cin >> name;
    // getline(cin, name);
    // cout << "Name: " << name << endl;
    // cout << "Age: " << endl;
    // int age;
    // cin >> age;
    // cout << "Age: " << age << endl;

    cout << boolalpha << true << endl;
    cout << setw(20) << setfill('#') << true << endl;
    double d = 1.23445567754456;
    cout << setprecision(8) << d << endl;
}