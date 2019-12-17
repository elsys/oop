main: employee.o manager.o
	g++ -o main main.cpp employee.o manager.o

employee.o:
	g++ -c employee.cpp
	
manager.o:
	g++ -c manager.cpp
	
clean:
	-rm *.o main
