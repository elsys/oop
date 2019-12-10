main: main.o airplane.o airliner.o airfreighter.o military_aircraft.o airport.o
	g++ main.o airplane.o airliner.o airfreighter.o military_aircraft.o airport.o -o main

main.o: main.cc airliner.hh airfreighter.hh military_aircraft.hh airport.hh
	g++ -c main.cc

airplane.o: airplane.cc airplane.hh airport.hh
	g++ -c airplane.cc

airliner.o: airliner.cc airliner.hh airplane.hh
	g++ -c airliner.cc

airfreighter.o: airfreighter.cc airfreighter.hh airplane.hh
	g++ -c airfreighter.cc

military_aircraft.o: military_aircraft.cc military_aircraft.hh airplane.hh
	g++ -c military_aircraft.cc

airport.o: airport.cc airport.hh airplane.hh
	g++ -c airport.cc

clean:
	rm main *.o
