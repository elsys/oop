main: main.o component.o cpu.o ram.o hd.o ps.o mother_board.o case.o
	g++ main.o component.o cpu.o ram.o hd.o ps.o mother_board.o case.o -o main

main.o: main.cc cpu.hh ram.hh hd.hh ps.hh mother_board.hh case.hh
	g++ -c main.cc

component.o: component.cc component.hh
	g++ -c component.cc

cpu.o: cpu.cc cpu.hh component.hh
	g++ -c cpu.cc

ram.o: ram.cc ram.hh component.hh
	g++ -c ram.cc

hd.o: hd.cc hd.hh component.hh
	g++ -c hd.cc

ps.o: ps.cc ps.hh component.hh
	g++ -c ps.cc

mother_board.o: mother_board.cc mother_board.hh component.hh cpu.hh ram.hh
	g++ -c mother_board.cc

case.o: case.cc case.hh component.hh mother_board.hh ps.hh hd.hh
	g++ -c case.cc

clean:
	rm main *.o
