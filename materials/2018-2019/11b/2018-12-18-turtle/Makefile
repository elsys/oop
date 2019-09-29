all: turtle

main.o: main.cc turtle.hh

turtle.o: turtle.cc turtle.hh

turtle: main.o turtle.o
	g++ -o turtle main.o turtle.o

clean:
	rm -fr *.o
	rm turtle

