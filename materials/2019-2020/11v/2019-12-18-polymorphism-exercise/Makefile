main: main.o circle.o rectangle.o square.o drawing.o point.o
	g++ main.o circle.o rectangle.o square.o drawing.o point.o -o main

main.o: main.cc shape.hh circle.hh rectangle.hh square.hh drawing.hh point.hh
	g++ -c main.cc

circle.o: circle.cc circle.hh shape.hh point.hh
	g++ -c circle.cc

rectangle.o: rectangle.cc rectangle.hh shape.hh point.hh
	g++ -c rectangle.cc

square.o: square.cc square.hh rectangle.hh
	g++ -c square.cc

drawing.o: drawing.cc drawing.hh shape.hh
	g++ -c drawing.cc

point.o: point.cc point.hh
	g++ -c point.cc

clean:
	rm main *.o
