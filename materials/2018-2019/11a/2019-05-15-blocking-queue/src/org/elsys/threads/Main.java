package org.elsys.threads;

public class Main {

    public static void main(String[] args) {
	    BlockingQueue<Integer> queue = new BlockingQueue<>(10);

        new Thread(() -> {
            for (int j = 0; j < 100000; j++) {
                try {
                    Thread.sleep(10);
                    queue.push(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

	    for (int i = 0; i < 10; i++) {
	        new Thread(() -> {
	            while (true) {
                    try {
                        Thread.sleep(100);
                        System.out.println(queue.pop());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
