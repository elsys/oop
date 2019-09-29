#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

class CalculatorError {
	string message_;
public:
	CalculatorError(string message) : message_(message) {}
	
	string get_message() const {
		return message_;
	}
};

class Operation {
	string symbol_;
public:
	Operation(string symbol) : symbol_(symbol) {}

	virtual void execute(vector<double>& values_) const = 0;

	string get_symbol() const {
		return symbol_;
	}
};

class UnaryOperation: public Operation {
public:
	UnaryOperation(string symbol) : Operation(symbol) {}
};

class BinaryOperation: public Operation {
public:
	BinaryOperation(string symbol) : Operation(symbol) {}

	void execute(vector<double>& values) const {
		if (values.size() < 1) {
			throw CalculatorError("not enough values...");
		}
		double value1 = values.back();
		values.pop_back();
		double value2 = values.back();
		values.pop_back();
		values.push_back(eval(value1, value2));
	}

protected:
	virtual double eval(double value1, double value2) const = 0;
};

class Plus: public BinaryOperation {
public:
	Plus() : BinaryOperation("+") {}
protected:
	double eval(double value1, double value2) const {
		return value1 + value2;
	}
};

class Minus: public BinaryOperation {
public:
	Minus() : BinaryOperation("-") {}
protected:
	double eval(double value1, double value2) const {
		return value1 - value2;
	}
};

class Calculator {
// 1. easily switch to different input streams
// 2. easily add new operations
	vector<Operation*> operations_;
	vector<double> values_;

	Operation* get_operation(string symbol) {
		for (vector<Operation*>::iterator it = operations_.begin();
				it != operations_.end(); it++) {
			if ((*it) -> get_symbol() == symbol) {
				return *it;
			}
		}
		return 0;
	}

public:

	void run(istream& in, ostream& out) {
		while (1) {
			out << "values(" << values_.size() << "): ";
			string input;
			in >> input;

			if (!in) {
				break;
			}
			
			Operation* operation = get_operation(input);
			if (operation) {
				operation -> execute(values_);
				cout << values_.back() << endl;
			} else {
				// is it a double?
				double new_value;
				stringstream istr(input);
				istr >> new_value;
				if (istr) {
					values_.push_back(new_value);
				} else {
					throw CalculatorError("unknown operation...");
				}
			}
		}
	}

	void addOperation(Operation* operation) {
		operations_.push_back(operation);
	}
};

int main() {
	Calculator calc;
	calc.addOperation(new Plus());
	calc.addOperation(new Minus());
	try {
		calc.run(cin, cout);
	} catch (CalculatorError err) {
		cout << err.get_message() << endl;
	}
	return 0;	
}








