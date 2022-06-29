package org.elsys.oop;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Restaurant r = new Restaurant();

        r.addCook(new Cook("Ivan"));
        r.addCook(new Cook("Georgi"));
        r.addCook(new Cook("Mariika"));

        r.addOven(new Oven());
        r.addOven(new Oven());

        r.addOrder(Order.GetClassicHamOrder("white bread"));
        r.addOrder(Order.GetClassicHamOrder("white bread"));

        Thread.sleep(3 * 1000);

        r.addOrder(Order.GetLongBurderOrder("white bread"));
        r.addOrder(Order.GetVeggieDelightOrder("white bread"));

        Thread.sleep(20 * 1000);
        r.shutdown();
    }
}
