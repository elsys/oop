/*
 * main.cc
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#include <iostream>
using namespace std;

#include "Interpreter.h"
#include "Plus.h"

int main() {
	try {
		Interpreter calc;
		calc.add_operation(new Plus(&calc));
		calc.run();
	} catch (InterpreterException e) {
		cerr << e.get_message() << endl;
	}
}





