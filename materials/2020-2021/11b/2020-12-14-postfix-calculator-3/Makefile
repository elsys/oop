DEPS = main.o calculator.o unaryOperation.o negate.o plus.o binaryOperation.o multiply.o compositeOperation.o

all: ${DEPS}
	g++ ${DEPS} -o calc 

# main.o: main.cpp 
#	g++ -Wall -c main.cpp
	
#calculator.o: calculator.cpp calculator.h
#	g++ -Wall -c calculator.cpp
	
%.o: %.cpp
	g++ -Wall -c $< -o $@
	
clean:
	rm -f a.out calc *.o
