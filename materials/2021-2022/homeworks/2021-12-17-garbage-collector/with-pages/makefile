DEPS = main.o GC.o BaseObject.o
CFLAGS = -Wall

all: ${DEPS}
	g++ ${CFLAGS} ${DEPS} -o demo.out

%.o: %.c
	g++ ${CFLAGS} -c $< -o $@

clean:
	rm *.out *.o *.txt
