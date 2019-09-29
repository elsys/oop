
all: draw


point.o: point.hh point.cc
	g++ -c point.cc

rectangle.o: rectangle.cc point.hh rectangle.hh shape.hh

main.o: main.cc point.hh rectangle.hh

draw: main.o point.o rectangle.o
	g++ -o draw main.o point.o rectangle.o

clean:
	rm -f *.o
	rm -f a.out
	rm -f draw



