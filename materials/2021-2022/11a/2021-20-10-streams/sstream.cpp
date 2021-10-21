#include <sstream>
#include <iostream>

using namespace std;

int main()
{
    // ostringstream out;
    // out << "Hello"
    //     << " "
    //     << "World"
    //     << 12312.12321
    //     << endl;

    // string name;
    // // name.append();
    // // name.append("asfadssaf");

    // cout << out.str() << endl;
    string value = "3.14 k4";
    istringstream in(value);

    double pi;
    in >> pi;
    // good - everything is ok
    // bad - can't open/read/write in the stream
    // fail - when operation fails
    // eof - reached end of file(string)
    if (in.good())
    {
        cout << pi << endl;
    }
    else
    {
        cout << "Something went wrong" << endl;
    }

    int number;
    in >> number;
    if (in.eof())
    {
        cout << "Reached end of string" << endl;
    }
    if (!in.fail())
    {
        cout << "Number: " << number << endl;
    }
    else
    {
        cout << "Something went wron" << endl;
    }

    in.clear();

    string str;
    in >> str;

    if (!in.fail())
    {
        cout << "Value: " << str << endl;
    }
    else
    {
        cout << "Something went very wrong" << endl;
    }
}