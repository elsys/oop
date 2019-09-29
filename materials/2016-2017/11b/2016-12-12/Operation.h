/*
 * Operation.hh
 *
 *  Created on: Dec 12, 2016
 *      Author: lubo
 */

#ifndef OPERATION_H_
#define OPERATION_H_

#include <string>

class Operation {
	std::string name_;

public:
	Operation(std::string name);
	virtual ~Operation();
	std::string get_name() const {
		return name_;
	}
	virtual void eval() const = 0;
};

#endif /* OPERATION_H_ */
