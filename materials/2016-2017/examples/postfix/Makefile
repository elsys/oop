CXXFLAGS = -g -Wall


OBJ = plus.o interpreter.o main.o binary_operation.o composite_operation.o

OUT = calc


all: $(OUT)


$(OUT): $(OBJ)
	g++ $(CXXFLAGS) $(OBJ) -o $(OUT)


clean:
	rm -f *~ a.out $(OUT) *.o files.pdf


files.pdf:
	enscript -r -2 --highlight --line-numbers -o - operation.hh \
	context.hh interpreter.hh interpreter.cc binary_operation.hh \
	binary_operation.cc plus.hh plus.cc composite_operation.hh \
	composite_operation.cc main.cc Makefile | ps2pdf - files.pdf

pdf: files.pdf
