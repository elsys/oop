#ifndef DRAWING_HH__
#define DRAWING_HH__

#include <list>

#include "Shape.hh"

class Drawing: public Shape {
	std::list<Shape*> shapes_;
public:

	Drawing();
	
	void add_shape(Shape* sh);
	void draw() const;

};


#endif

