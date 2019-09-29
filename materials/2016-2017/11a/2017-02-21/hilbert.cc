#include <iostream>
#include <vector>

using namespace std;

class Point {
	int x_, y_;
	
public:
	Point(int x, int y) : x_(x), y_(y) {}

	int get_x() const {
		return x_;
	}
	
	int get_y() const {
		return y_;
	}
	
	Point move_with(int x, int y) const {
		return Point(x_ + x, y_ + y);
	}
};

class HilbertCurve {

	vector<Point> curve_;

	static void concat(vector<Point>& target, vector<Point> source) {
		target.insert(target.end(), source.begin(), source.end());
	}

	vector<Point> up(Point start, int order, int line) {
		vector<Point> result;
		if (order == 0) {
			result.push_back(start);
			return result;
		}
		// left
		concat(result, left(start, order - 1, line));
		// up
		start = result.back().move_with(0, -line);
		concat(result, up(start, order - 1, line));
		// up
		start = result.back().move_with(line, 0);
		concat(result, up(start, order -1, line));
		// right
		start = result.back().move_with(0, line);
		concat(result, right(start, order - 1, line));
		return result;
	}
	
	vector<Point> down(Point start, int order, int line) {
		vector<Point> result;
		if (order == 0) {
			result.push_back(start);
			return result;
		}
		// left
		concat(result, right(start, order - 1, line));
		// up
		start = result.back().move_with(0, line);
		concat(result, down(start, order - 1, line));
		// up
		start = result.back().move_with(-line, 0);
		concat(result, down(start, order -1, line));
		// right
		start = result.back().move_with(0, -line);
		concat(result, left(start, order - 1, line));
		return result;
	}
	
	vector<Point> left(Point start, int order, int line) {
		vector<Point> result;
		if (order == 0) {
			result.push_back(start);
			return result;
		}
		// left
		concat(result, up(start, order - 1, line));
		// up
		start = result.back().move_with(line, 0);
		concat(result, left(start, order - 1, line));
		// up
		start = result.back().move_with(0, -line);
		concat(result, left(start, order -1, line));
		// right
		start = result.back().move_with(-line, 0);
		concat(result, down(start, order - 1, line));
		return result;
	}
	
	vector<Point> right(Point start, int order, int line) {
		vector<Point> result;
		if (order == 0) {
			result.push_back(start);
			return result;
		}
		// left
		concat(result, down(start, order - 1, line));
		// up
		start = result.back().move_with(-line, 0);
		concat(result, right(start, order - 1, line));
		// up
		start = result.back().move_with(0, line);
		concat(result, right(start, order -1, line));
		// right
		start = result.back().move_with(line, 0);
		concat(result, up(start, order - 1, line));
		return result;
	}

public:

	HilbertCurve(int order, int width) {
		curve_ = up(Point(0, width),order, width / count_lines(order));
	}

	static int count_lines(int order) {
		if (order == 1) {
			return 1;
		}
		return 2 * count_lines(order - 1) + 1;
	}
	
	void print() {
		cout << "newpath" << endl;
        cout << curve_[0].get_x() << " " << curve_[0].get_y() << " moveto" << endl;
        for(int i = 1; i < curve_.size(); i++) {
            cout << curve_[i].get_x() << " " << curve_[i].get_y() << " lineto" << endl;
        }
        cout << "stroke" << endl;
	}
};

int main() {
	HilbertCurve hc(8, 600);
	hc.print();
	return 0;
}






