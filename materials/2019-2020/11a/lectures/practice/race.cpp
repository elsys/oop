#include <algorithm>
#include <exception>
#include <iostream>
#include <iterator>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

class InvalidNameException : exception {
	string message;
  public:
	InvalidNameException(string _message) {
		message = _message;
	}
	string getMessage() {
		return message;
	}
};
class InvalidSpeedException : exception {};

class Contestant {
	string name;
	double speed;
	double distance;
  public:
	Contestant(string name, double speed);
	Contestant();
	string getName();
	double getSpeed();
	double getDistance();
	void calcDistance(int iteration_count);
	void resetDistance();
};

class Race {
	vector<Contestant> contestants;
  public:
	Race(vector<Contestant> contestants);
	vector<Contestant> getContestants();
	void addContestant(Contestant new_contestant);
	void resetContestants();
	void simulateRace(int iteration_count);
	string getContestantStanding();
};

bool compareContestants(Contestant c1, Contestant c2) {
	return c1.getDistance() > c2.getDistance();
}

int main() {
	Contestant c1("C1", 10);
	Contestant c2("C2", 20);
	Contestant c3("", 5);
	vector<Contestant> contestants;
	contestants.push_back(c1);
	contestants.push_back(c2);
	contestants.push_back(c3);
	try {
		Race r(contestants);
		r.simulateRace(5);
	} catch (InvalidNameException e) {
		cout << e.getMessage() << endl;
	}
	return 0;
}

Contestant::Contestant(string _name, double _speed) {
	name = _name;
	speed = _speed;
	distance = 0;
}

Contestant::Contestant() {
	Contestant("", 0);
}

string Contestant::getName() {
	return name;
}

double Contestant::getSpeed() {
	return speed;
}

double Contestant::getDistance() {
	return distance;
}

void Contestant::calcDistance(int iteration_count) {
	distance += speed * iteration_count;
}

void Contestant::resetDistance() {
	distance = 0;
}

vector<Contestant> Race::getContestants() {
	return contestants;
}

Race::Race(vector<Contestant> _contestants) {
	for (Contestant c : _contestants) {
		if (c.getName().length() == 0) { throw InvalidNameException("Empty name"); }
		if (c.getSpeed() <= 0) { throw InvalidSpeedException(); }
	}
	contestants = _contestants;
}

void Race::addContestant(Contestant new_contestant) {
	if (new_contestant.getName().length() == 0) { throw InvalidNameException("Empty name"); }
	if (new_contestant.getSpeed() <= 0) { throw InvalidSpeedException(); }
	contestants.push_back(new_contestant);
}

void Race::resetContestants() {
	for (auto it = contestants.begin(); it != contestants.end(); it++) {
		it->resetDistance();
	}
}

void Race::simulateRace(int iteration_count) {
	resetContestants();
	cout << getContestantStanding() << endl;
	for (int i = 0; i < iteration_count; i++) {
		for (auto it = contestants.begin(); it != contestants.end(); it++) {
			it->calcDistance(1);
		}
		sort(contestants.begin(), contestants.end(), compareContestants);
		cout << getContestantStanding() << endl;
	}
}

string Race::getContestantStanding() {
	stringstream ss;
	for (auto it : contestants) {
		ss << it.getName() << ": ";
		ss << it.getDistance() << '(' << it.getSpeed() << ')' << endl;
	}
	return ss.str();
}
