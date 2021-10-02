#include <math.h>
#include <iostream>
#include <sstream>
#include <string>

using std::cout;
using std::cin;
using std::endl;
using std::string;

class Point
{
	private:
		int x, y;
	public:
		Point()
        {
            this->x = 0;
			this->y = 0;
        }
		
		Point(int x, int y)
		{
			this->x = x;
			this->y = y;
		}
		
		Point(const Point& p)
		{
			this->x = p.x;
			this->y = p.y;
		}
		
        int getx() { return this->x; }
        int gety() { return this->y; }
		
        void setx(int x) { this->x = x; }
        void sety(int y) { this->y = y; }
		
        void moveTo(int dx, int dy)
        {
            this->x += dx;
            this->y += dy;
        }
        string toString()
        {
			std::stringstream ss;
			ss << "(" << this->x << "," << this->y << ")";
			return ss.str();
        }
}; 

int main(int argc, char *argv[])
{
    Point* p1 = new Point(0,0);
    Point* p2 = new Point(2,2);

	double distance = sqrt( pow((p2->getx() - p1->getx()),2) + pow((p2->gety() - p1->gety()),2));

    cout << "Distance between " << p1->toString() << " and " << p2->toString() << " is " << distance << endl;

	Point* p3 = new Point(*p2);
	
	delete p1;
	delete p2;
	delete p3;
	
    return 0;
}
