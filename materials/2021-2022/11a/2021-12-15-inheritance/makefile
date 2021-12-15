all: company

manager.o: manager.cpp manager.hh employee.cpp employee.hh
	g++ -c manager.cpp

employee.o: employee.cpp employee.hh
	g++ -c employee.cpp

main.o: main.cpp manager.cpp manager.hh employee.cpp employee.hh
	g++ -c main.cpp

company: manager.o employee.o main.o
	g++ -o  ../company manager.o employee.o main.o

clean:
	rm -f *.o company