all: postfix

calculator.o: operation.hh calculator.hh calculator.cc

postfix.o: postfix.cc calculator.hh

postfix: postfix.o calculator.o
	g++ -o postfix postfix.o calculator.o

clean:
	rm -fr *.o
	rm -fr postfix

