
all: calculator.o negative.o not.o
	g++ -Wall calculator.o negative.o not.o -o calc

calculator.o:
	g++ -Wall -c calculator.cpp
	
negative.o:
	g++ -Wall -c negative.cpp
		
not.o:
	g++ -Wall -c not.cpp
	
clean:
	rm -f a.out calc *.o
