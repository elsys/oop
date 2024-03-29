#ifndef SHAPE_HH
#define SHAPE_HH

class Shape {
public:
  virtual Shape* clone() const = 0;

  virtual void draw() const = 0;

  virtual double get_perimeter() const = 0;

  virtual double get_area() const = 0;
};

#endif
