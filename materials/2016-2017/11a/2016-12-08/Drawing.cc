#include <iostream>

#include "Drawing.hh"


Drawing::Drawing()
{}

void Drawing::add_shape(Shape* sh) {
	shapes_.push_back(sh);
}

void Drawing::draw() const {
	std::cout << "Drawing::draw {";
	for(std::list<Shape*>::const_iterator it=shapes_.begin();
			it!=shapes_.end();
			++ it) {
		
		(*it) -> draw();	
	}
	std::cout << "}" << std::endl;
}
