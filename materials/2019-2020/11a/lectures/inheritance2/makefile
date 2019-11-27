main: animal.o mammal.o bird.o fish.o canWalk.o canFly.o canSwim.o lion.o whale.o salomon.o flyingFish.o ostrich.o seagull.o
	g++ -o main main.o animal.o mammal.o bird.o fish.o canWalk.o canFly.o canSwim.o lion.o whale.o salomon.o flyingFish.o ostrich.o seagull.o

animal.o: animal.cpp animal.h
	g++ -c animal.cpp

seagull.o: animal.cpp animal.h bird.h bird.cpp seagull.cpp seagull.h
	g++ -c seagull.cpp

ostrich.o: animal.cpp animal.h bird.h bird.cpp ostrich.cpp ostrich.h
	g++ -c ostrich.cpp

flyingFish.o: animal.cpp, animal.h fish.h fish.cpp flyingFish.cpp flyingFish.h
	g++ -c flyingFish.cpp

salomon.o: animal.cpp animal.h fish.h fish.cpp salomon.cpp salomon.h
	g++ -c salomon.cpp

whale.o: animal.cpp animal.h mammal.h mammal.cpp whale.cpp whale.h
	g++ -c whale.cpp

lion.o: animal.cpp animal.h mammal.h mammal.cpp lion.cpp lion.h
	g++ -c lion.cpp

canSwim.o: canSwim.cpp canSwim.h
	g++ -c canSwim.cpp

canFly.o: canFly.cpp canFly.h
	g++ -c canFly.cpp

canWalk.o: canWalk.cpp canWalk.h
	g++ -c canWalk.cpp

fish.o: animal.cpp animal.h fish.h fish.cpp
	g++ -c fish.cpp

bird.o: animal.cpp animal.h bird.h bird.cpp
	g++ -c bird.cpp

mammal.o: animal.cpp animal.h mammal.h mammal.cpp
	g++ -c mammal.cpp
