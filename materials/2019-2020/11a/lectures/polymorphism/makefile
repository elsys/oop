main: employee.o manager.o
	g++ -o main main.cpp manager.o employee.o
	
manager.o:
	g++ -c manager.cpp
	
employee.o:
	g++ -c employee.cpp
	
clean:
	-rm *.o main
