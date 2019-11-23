CC = g++

SRCS := $(wildcard *.cc)
OBJS := $(SRCS:%.cc=%.o)

all: ${OBJS}
	${CC} -o game ${OBJS}

%.o: %.cc
	${CC} -c $<

clean:
	rm -rvf *.o game
