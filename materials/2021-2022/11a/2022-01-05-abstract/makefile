all: drawing

drawing: main.o circle.o shape.hh sqare.o rectangle.o point.o
	g++ -o drawing main.o circle.o rectangle.o sqare.o

main.o: main.cpp shape.hh circle.o sqare.o rectangle.o
	g++ -c main.cpp

circle.o: circle.cpp shape.hh circle.hh point.o
	g++ -c circle.cpp

rectangle.o: rectangle.cpp rectangle.hh point.o shape.hh
	g++ -c rectangle.cpp

sqare.o: sqare.cpp sqare.hh shape.hh point.o
	g++ -c sqare.cpp

point.o:  point.cpp point.hh
	g++ -c point.cpp

clean:
	rm -f *.o drawing