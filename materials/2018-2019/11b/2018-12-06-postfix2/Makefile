all: postfix

calculator.o: operation.hh calculator.hh calculator.cc

unary.o: unary.hh unary.cc

negate.o: negate.hh negate.cc

postfix.o: postfix.cc calculator.hh

postfix: postfix.o calculator.o unary.o negate.o
	g++ -o postfix postfix.o calculator.o unary.o negate.o

clean:
	rm -fr *.o
	rm -fr postfix

