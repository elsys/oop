#include <string>
#include <iostream>

using namespace std;

int main()
{
    string data = "id name price";
    int first_space = data.find_first_of(" ");
    int last_space = data.find_last_of(" ");
    cout << "first: " << first_space << " last space: " << last_space << endl;
    string name = data.substr(first_space + 1, last_space - first_space - 1);
    cout << data[6] << endl;
    cout << "name: " << name << "A" << endl;
}