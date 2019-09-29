
CXXFLAGS = -g -Wall


OBJ = Interpreter.o main.o Plus.o Operation.o

OUT = postfix


all: $(OUT)


$(OUT): $(OBJ)
	g++ $(CXXFLAGS) $(OBJ) -o $(OUT)


clean:
	rm -f *~ a.out $(OUT) *.o


