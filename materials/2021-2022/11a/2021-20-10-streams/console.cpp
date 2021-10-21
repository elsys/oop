#include <iostream>

using namespace std;

class Point
{
private:
    int x;
    int y;

public:
    Point(int x, int y)
    {
        this->x = x;
    }

    void set_x(int x)
    {
        if (x < 0)
        {
            throw
        }
        this->x = x;
    }
};

int main(int argc, char *argv[])
{
    for (int i = 0; i < argc; i++)
    {
        cout << argv[i] << endl;
    }
}