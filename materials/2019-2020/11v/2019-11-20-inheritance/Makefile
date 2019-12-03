main: main.o manager.o employee.o
	g++ main.o manager.o employee.o -o main

main.o: main.cc employee.hh manager.hh
	g++ -c main.cc

employee.o: employee.cc employee.hh
	g++ -c employee.cc

manager.o: manager.cc manager.hh
	g++ -c manager.cc

clean:
	rm main *.o
