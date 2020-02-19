package org.elsys.mbenov;

public class Iliana {
    public static char gender = 'F';
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void increment() {
        count++;
    }

    public String name;
    private int age;

    public int getAge() {
        return age;
    }

    public Iliana() {
//        name = "org.elsys.mbenov.Iliana";
//        age = 17;
        this("org.elsys.mbenov.Iliana", 17);
    }

    public Iliana(String name, int age) {
        this.name = name;
        this.age = age;
        Iliana.increment();
    }
}
