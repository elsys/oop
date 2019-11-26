zoo: main.o animal.o mammal.o fish.o bird.o can_walk.o can_swim.o can_fly.o lion.o whale.o salmon.o flying_fish.o seagull.o ostrich.o
	g++ -o zoo main.o animal.o mammal.o fish.o bird.o can_walk.o can_swim.o can_fly.o lion.o whale.o salmon.o flying_fish.o seagull.o ostrich.o

main.o: main.cpp
	g++ -c main.cpp

animal.o: animal.cpp animal.hpp
	g++ -c animal.cpp

mammal.o: mammal.cpp mammal.hpp
	g++ -c mammal.cpp

fish.o: fish.cpp fish.hpp
	g++ -c fish.cpp

bird.o: bird.cpp bird.hpp
	g++ -c bird.cpp

can_walk.o: can_walk.cpp can_walk.hpp
	g++ -c can_walk.cpp

can_swim.o: can_swim.cpp can_swim.hpp
	g++ -c can_swim.cpp

can_fly.o: can_fly.cpp can_fly.hpp
	g++ -c can_fly.cpp

lion.o: lion.cpp lion.hpp
	g++ -c lion.cpp

whale.o: whale.cpp whale.hpp
	g++ -c whale.cpp

salmon.o: salmon.cpp salmon.hpp 
	g++ -c salmon.cpp

flying_fish.o: flying_fish.cpp flying_fish.hpp
	g++ -c flying_fish.cpp

seagull.o: seagull.cpp seagull.hpp
	g++ -c seagull.cpp

ostrich.o: ostrich.cpp ostrich.hpp
	g++ -c ostrich.cpp


clean:
	rm *.o zoo
