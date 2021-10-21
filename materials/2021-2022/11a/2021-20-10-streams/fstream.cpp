#include <fstream>
#include <iostream>

using namespace std;

int main()
{
    ofstream out;
    ifstream in;
    fstream stream;
    // stream.open("text.txt", ios_base::in | ios_base::out | ios_base::app);
    // out.open("text.txt", ios_base::app);
    out.open("text.txt");
    string name;
    cout << "Enter name: " << endl;
    getline(cin, name);
    out << name << endl;
    cout << "Enter age: " << endl;
    int age;
    cin >> age;
    out << age << endl;

    in.open("text.txt");
    string name2;
    getline(in, name2);
    int age2;
    in >> age2;
    cout << "Name: " << name2 << " Age: " << age2 << endl;
}