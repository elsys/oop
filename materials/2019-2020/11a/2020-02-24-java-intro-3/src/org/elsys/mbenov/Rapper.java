package org.elsys.mbenov;

public class Rapper {
    private static int count = 0;
    public static void increment() {
        count++;
    }
    public static int getCount() {
        return count;
    }

    public String name;
    private int earnings;

    public int getEarnings() {
        return earnings;
    }

    public Rapper() {
        //name = "Ivan";
        //earnings = 0;
        this("Ivan", 0);
    }

    public Rapper(String name, int earnings) {
        this.name = name;
        this.earnings = earnings;
        Rapper.increment();
//        org.elsys.mbenov.Rapper.count = 15;
//        org.elsys.mbenov.Rapper.count -=10;
    }
}
