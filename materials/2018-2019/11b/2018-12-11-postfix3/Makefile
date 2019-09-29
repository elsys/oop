all: postfix

calculator.o: calculator.cc operation.hh calculator.hh

unary.o: unary.cc unary.hh operation.hh

negate.o: negate.cc negate.hh operation.hh
binary.o: binary.cc binary.hh operation.hh

postfix.o: postfix.cc calculator.hh binary.hh operation.hh negate.hh stack_operations.hh composite.hh

postfix: postfix.o calculator.o unary.o negate.o binary.o
	g++ -o postfix postfix.o calculator.o unary.o negate.o binary.o

clean:
	rm -fr *.o
	rm -fr postfix

