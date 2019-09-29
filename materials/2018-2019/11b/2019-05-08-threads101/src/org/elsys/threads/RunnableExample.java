package org.elsys.threads;

public class RunnableExample {

    public static void main(String[] args) {
        String[] names = {"Misho", "Ivan", "Lubo", "Joro", "Petar"};
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new StudentRunnable(names[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("End of main");
    }

}

class StudentRunnable implements Runnable {

    private final String name;

    StudentRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started doing his OOP homework...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ready!");
    }
}