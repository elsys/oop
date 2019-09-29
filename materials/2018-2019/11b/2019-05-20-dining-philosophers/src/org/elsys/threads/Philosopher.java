package org.elsys.threads;

public class Philosopher implements Runnable {

    private final String name;
    private final Fork left;
    private final Fork right;

    public Philosopher(String name, Fork left, Fork right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void think() {
        System.out.printf("%s is thinking\n", name);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat() {
        System.out.printf("%s is hungry\n", name);
        left.get();
        right.get();
        System.out.printf("%s is eating\n", name);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        left.put();
        right.put();
    }

    public void sleep() {
        System.out.printf("%s is sleeping\n", name);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            think();
            eat();
            sleep();
        }
    }
}
