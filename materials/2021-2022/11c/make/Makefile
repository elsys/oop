all: main

main: point.o main.o
	g++ -o main.exe main.o point.o

point.o: point.cpp point.h
	g++ -c point.cpp

main.o: main.cpp
	g++ -c main.cpp