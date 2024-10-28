class Main {
  public static void main(String[] args) {
    Human h1 = new Human("Ivan");
    h1.sayHello();

    Racer h2 = new Racer("Dragan", 10);
    h2.sayHello();

    Human h3 = new Racer("Petkan", 20);
    h3.sayHello();

    Animal a1 = new Dog();
    a1.makeSound();

    h2.addLapTime(10);
    h2.getAllTimes();

    // h3.addLapTime(20);

    Racetime rt1 = new Racer("Galabin", 20);
    rt1.addLapTime(20);
  }
}