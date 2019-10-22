#include <exception>
#include <iostream>
#include <list>
#include <sstream>
#include <string>
using namespace std;

class TooManyMarksException : exception {};
class InvalidMarkException : exception {};
class TooSmallNameException : exception {};

class StudentInfo {
	string name;
	list<double> marks;
  public:
	StudentInfo(string _name, list<double> _marks);
	StudentInfo();
	string getName();
	list<double> getMarks();
	void addMark(double new_mark);
	double getAverage();
	string toString();
};

int main() {
	list<double> marks = { 3.5, 4, 5.5, 6 };
	StudentInfo si("student", marks);
	cout << si.toString() << endl;
	return 0;
}

StudentInfo::StudentInfo(string _name, list<double> _marks) {
	if (_marks.size() >= 10) { throw TooManyMarksException(); }
	for (double mark : _marks) {
		if (mark < 2 || mark > 6) { throw InvalidMarkException(); }
	}
	if (_name.length() < 5) { throw TooSmallNameException(); }
	name = _name;
	marks = _marks;
}

StudentInfo::StudentInfo() {
	name = "";
}

string StudentInfo::getName() {
	return name;
}

list<double> StudentInfo::getMarks() {
	return marks;
}

void StudentInfo::addMark(double new_mark) {
	if (marks.size() >= 10) { throw TooManyMarksException(); }
	if (new_mark < 2 || new_mark > 6) { throw InvalidMarkException(); }
	marks.push_back(new_mark);
}

double StudentInfo::getAverage() {
	double sum = 0;
	for (double mark : marks) {
		sum += mark;
	}
	return sum / marks.size();
}

string StudentInfo::toString() {
	stringstream ss;
	ss << name << ':';
	for (double mark : marks) {
		ss << ' ' << mark;
	}
	ss << ' ' << '[' << getAverage() << ']';
	return ss.str();
}
