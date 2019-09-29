
CXXFLAGS = -g -Wall


OBJ = calculator.o context.o postfix.o binary.o composite_operation.o

OUT = postfix


all: $(OUT)


$(OUT): $(OBJ)
	g++ $(CXXFLAGS) $(OBJ) -o $(OUT)


clean:
	rm -f *~ a.out $(OUT) *.o


