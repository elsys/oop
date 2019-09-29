all: postfix

calculator.o: calculator.hh calculator.cc

postfix.o: postfix.cc calculator.hh

unary.o: unary.cc unary.hh

negate.o: negate.cc negate.hh

square.o: square.cc square.hh

postfix: calculator.o postfix.o negate.o square.o unary.o
	g++ -o postfix postfix.o calculator.o negate.o square.o unary.o

clean:
	rm -f *.o
	rm -f a.out
	rm -f postfix
