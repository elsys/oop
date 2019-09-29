package org.elsys.threads;

public class Main {

    public static void main(String[] args) {
	    BlockingQueue<Integer> queue = new BlockingQueue<>(10);
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                queue.push(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    System.out.println(queue.pop());
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
