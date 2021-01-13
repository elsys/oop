
all: calculator.o negative.o not.o plus.o multiply.o
	g++ -Wall calculator.o negative.o not.o plus.o multiply.o -o calc

calculator.o: calculator.cpp calculator.h
	g++ -Wall -c calculator.cpp
	
negative.o: negative.cpp negative.h unary_operation.h
	g++ -Wall -c negative.cpp
		
not.o: not.cpp not.h unary_operation.h
	g++ -Wall -c not.cpp

plus.o: plus.cpp plus.h binary_operation.h
	g++ -Wall -c plus.cpp

multiply.o: multiply.cpp multiply.h binary_operation.h
	g++ -Wall -c multiply.cpp
	
clean:
	rm -f a.out calc *.o
