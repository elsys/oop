all: postfix

calculator.o: calculator.hh calculator.cc

postfix.o: postfix.cc calculator.hh

postfix: calculator.o postfix.o
	g++ -o postfix postfix.o calculator.o

clean:
	rm -f *.o
	rm -f a.out
	rm -f postfix
