#include "Vector.hh"
#include <iostream>

using namespace std;

void print1(const Vector &v)
{
    for (int i = 0; i < v.get_size(); i++)
    {
        cout << v[i] << endl;
    }
}

void print2(const Vector &v)
{
    for (auto it = v.begin(); it < v.end(); it++)
    {
        cout << *it << endl;
    }
}

int main()
{
    Vector v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    print1(v);
    print2(v);
}