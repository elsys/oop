/*
 * Plus.h
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#ifndef PLUS_H_
#define PLUS_H_
#include "Operation.h"


class Plus: public Operation {
public:
	Plus(Interpreter* calc);
	
	void eval() const;
};

#endif /* PLUS_H_ */
