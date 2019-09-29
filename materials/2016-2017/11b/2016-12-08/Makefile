all: shapes

Point.o: Point.cc Point.hh

Circle.o: Circle.cc Circle.hh

Rectangle.o: Rectangle.cc Rectangle.hh

main.o: main.cc

shapes: main.o Point.o Circle.o Rectangle.o
	g++ main.o Point.o Circle.o Rectangle.o -o shapes

clean:
	rm -f *.o *~ shapes
