main: main.o device.o laptop.o car.o inventory.o
	g++ main.o device.o laptop.o car.o inventory.o -o main

main.o: main.cc laptop.hh car.hh inventory.hh
	g++ -c main.cc

device.o: device.cc device.hh
	g++ -c device.cc

laptop.o: laptop.cc laptop.hh device.hh
	g++ -c laptop.cc

car.o: car.cc car.hh device.hh
	g++ -c car.cc

inventory.o: inventory.cc inventory.hh device.hh laptop.hh car.hh
	g++ -c inventory.cc

clean:
	rm -rf main *.o
