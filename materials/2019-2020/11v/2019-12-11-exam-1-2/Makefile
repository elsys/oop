main: main.o musical_instrument.o guitar.o acoustic.o electric.o music_store.o
	g++ main.o musical_instrument.o guitar.o acoustic.o electric.o music_store.o -o main

main.o: main.cc acoustic.hh electric.hh music_store.hh
	g++ -c main.cc

musical_instrument.o: musical_instrument.cc musical_instrument.hh
	g++ -c musical_instrument.cc

guitar.o: guitar.cc guitar.hh musical_instrument.hh
	g++ -c guitar.cc

acoustic.o: acoustic.cc acoustic.hh guitar.hh
	g++ -c acoustic.cc

electric.o: electric.cc electric.hh guitar.hh
	g++ -c electric.cc

music_store.o: music_store.cc music_store.hh guitar.hh acoustic.hh electric.hh
	g++ -c music_store.cc

clean:
	rm main *.o
