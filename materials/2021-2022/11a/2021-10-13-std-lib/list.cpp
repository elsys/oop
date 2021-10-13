#include <list>
#include <iostream>

using namespace std;

int main()
{
    list<int> l;
    for (int i = 0; i < 10; i++)
    {
        l.push_back(i);
    }
    cout << "Size: " << l.size() << endl;

    // list<int>::iterator it = l.begin();
    auto it = l.begin();
    while (it != l.end())
    {
        cout << *it << endl;
        it++;
    }
}