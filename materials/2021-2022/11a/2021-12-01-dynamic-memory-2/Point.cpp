class Point
{
    int x;
    int y;
    int *data;

public:
    Point(int x, int y)
    {
        this->x = x;
        this->y = y;
    }

    //copy constructor.
    //Default implementation from the compilator. When we use dynamic memory we need to define our own copy constructor
    Point(const Point &other) : x(other.x), y(other.y), data(other.data) //data will point to already alocated memory
    {
    }

    //
    Point &operator=(const Point &other)
    {
        x = other.x;
        y = other.y;
        //data = other.data;
    }
};