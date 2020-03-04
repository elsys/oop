main: main.o stack.o
	g++ -o main main.o stack.o
	
stack.o: stack.cpp stack.h
	g++ -c stack.cpp
	
main.o: main.cpp
	g++ -c main.cpp
	
clean:
	-rm *.o main
