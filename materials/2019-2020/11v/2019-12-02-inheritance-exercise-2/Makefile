main: main.o beverage.o alcoholic.o non_alcoholic.o beer.o wine.o order.o client.o
	g++ main.o beverage.o alcoholic.o non_alcoholic.o beer.o wine.o order.o client.o -o main

main.o: main.cc wine.hh beer.hh order.hh client.hh
	g++ -c main.cc

beverage.o: beverage.cc beverage.hh
	g++ -c beverage.cc

alcoholic.o: alcoholic.cc alcoholic.hh beverage.hh
	g++ -c alcoholic.cc

non_alcoholic.o: non_alcoholic.cc non_alcoholic.hh beverage.hh
	g++ -c non_alcoholic.cc

beer.o: beer.cc beer.hh alcoholic.hh
	g++ -c beer.cc

wine.o: wine.cc wine.hh alcoholic.hh
	g++ -c wine.cc

order.o: order.cc order.hh beverage.hh
	g++ -c order.cc

client.o: client.cc client.hh order.hh
	g++ -c client.cc

clean:
	rm main *.o
