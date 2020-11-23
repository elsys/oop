main: main.o employee.o manager.o
	g++ -o main main.o employee.o manager.o

main.o: main.cpp
	g++ -c main.cpp

manger.o: manager.cpp manager.h
	g++ -c manager.cpp

employee.o: employee.cpp employee.h
	g++ -c employee.cpp

clean:
	-rm *.o
	-rm main