#include <iostream>
using namespace std;

// int Max(int a, int b)
// {
//     return a > b ? a : b;
// }

// double Max(double a, double b)
// {
//     return a > b ? a : b;
// }

// template<class R, class T...>
// R Max(T t) {
//     ...
// }

template <class T>
T Max(T a, T b)
{
    return a > b ? a : b;
}

template <class T>
T Min(T a, T b)
{
    return a < b ? a : b;
}

int main()
{
    int a = 2;
    int b = 3;
    cout << Max(a, b) << endl;

    double aa = 2.2;
    double bb = 3.3;
    cout << Max(aa, bb) << endl;
}