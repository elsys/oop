#include <map>
#include <iostream>

using namespace std;

int main()
{
    map<int, int> m = {{1, 2}, {2, 3}};
    m.insert({3, 3});
    m.insert({4, 4});
    cout << m[4] << endl;
}