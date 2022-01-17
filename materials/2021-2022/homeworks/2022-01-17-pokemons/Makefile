DEPS = main.o pokemon.o skill.o status_effect.o
CFLAGS = -Wall -lm -pedantic

all: ${DEPS}
	g++ -Wall ${DEPS}

%.o: %.c
	gcc ${CFLAGS} -c $< -o $@

clean:
	rm a.out *.o
