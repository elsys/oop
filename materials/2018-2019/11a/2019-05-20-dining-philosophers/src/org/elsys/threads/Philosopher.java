package org.elsys.threads;

public class Philosopher implements Runnable {

    private final String name;
    private Fork left;
    private Fork right;

    public Philosopher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLeft(Fork left) {
        this.left = left;
    }

    public void setRight(Fork right) {
        this.right = right;
    }

    @Override
    public void run() {
        if (left == null || right == null) {
            throw new RuntimeException(name + " is not seated");
        }
        while (true) {
            think();
            eat();
        }
    }

    public void eat() {
        System.out.printf("%s is hungry\n", name);
        left.get();
        right.get();
        try {
            System.out.printf("%s is eating\n", name);
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        right.put();
        left.put();
    }

    public void think() {
        try {
            System.out.printf("%s is thinking\n", name);
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
