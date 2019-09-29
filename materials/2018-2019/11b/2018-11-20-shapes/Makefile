

all: draw

point.o: point.cc point.hh
	g++ -c point.cc

rectangle.o: rectangle.cc rectangle.hh shape.hh point.hh

main.o: main.cc rectangle.hh point.hh shape.hh

draw: main.o rectangle.o point.o
	g++ -o draw main.o rectangle.o point.o

clean:
	rm -f *.o
	rm -f a.out
	rm -f draw

