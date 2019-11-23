#include <string>
#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

class Point {
public:
  int x;
  int y;
  
  Point() {
    x = 0;
    y = 0;
  }
  
  Point(int px, int py) {
    x = px;
    y = py;
  }
  
  string toString() {
    ostringstream oss;
    oss << "(" << x << ", " << y << ")" << endl;
    return oss.str();
  }
};

class PointCollector {
  vector<Point> points;
public:
  void readPoints() {
    string line;
    while(!cin.eof()) {
      getline(cin, line);
      stringstream ss(line);
      
      int x;
      int y;
      
      ss.ignore(1);
      ss >> x;
      ss.ignore(2);
      ss >> y;
      
      points.push_back(Point(x,y));
    }
    
    Point avg;
    
    for(auto it = points.begin(); it != points.end(); it++) {
      Point p = *it;
      avg.x += p.x;
      avg.y += p.y;
    }
    
    avg.x /= points.size();
    avg.y /= points.size();
    
    cout << "Average: " << avg.toString() << endl;
  }
};

int main() {
  Point p;
  
  cout << p.toString() << endl;

  PointCollector pc;
  pc.readPoints();  
  
  return 0;
}

