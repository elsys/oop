all: turtle

main.o: main.cc turtle.hh

turtle.o: turtle.cc turtle.hh

turtle: turtle.o main.o
	g++ -o turtle turtle.o main.o turtle.hh

clean:
	rm -fr *.o
	rm turtle

