main: main.o stack.o
	g++ -o main main.o stack.o

main.o: main.cpp
	g++ -c main.cpp

stack.o: stack.h stack.cpp
	g++ -c stack.cpp
	
clean:
	rm *.o main
