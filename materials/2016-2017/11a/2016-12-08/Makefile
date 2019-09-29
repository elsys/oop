all: main

Point.o: Point.cc Point.hh

Circle.o: Circle.cc Circle.hh Shape.hh

Drawing.o: Drawing.cc Drawing.hh Shape.hh

main.o: main.cc Point.hh Circle.hh

main: main.o Point.o Circle.o Drawing.o
	g++ -o main main.o Point.o Circle.o Drawing.o

clean:
	rm -f *.o *~ main
