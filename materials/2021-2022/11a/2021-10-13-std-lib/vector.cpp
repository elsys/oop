#include <iostream>
#include <vector>

using namespace std;

class Test
{
    int value;
};

int main()
{
    // vector<Test> v;
    vector<int> v;
    for (int i = 0; i < 10; i++)
    {
        cout << "Size: " << v.size() << endl;
        cout << "Capacity: " << v.capacity() << endl;
        v.push_back(i);
    }

    for (int i = 0; i < 10; i++)
    {
        cout << v[i] << endl;
    }

    v.shrink_to_fit();
    cout << "Shrinked capacity: " << v.capacity() << endl;
}