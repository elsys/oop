main: main.o employee.o manager.o
	g++ -o main main.o employee.o manager.o

main.o: main.cpp employee.h manager.h
	g++ -c main.cpp

manager.o: manager.cpp manager.h
	g++ -c manager.cpp

employee.o: employee.cpp employee.h
	g++ -c employee.cpp

clean:
	-rm *.o
