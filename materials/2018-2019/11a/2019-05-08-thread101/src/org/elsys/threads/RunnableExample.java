package org.elsys.threads;

public class RunnableExample {


    private static class StudentRunnable implements Runnable {

        private final String name;

        private StudentRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is doing his OOP homework...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done!");
        }
    }



    public static void main(String[] args) {
        String[] names = {"Meri", "Joro", "Ivan", "Pesho", "Lubo"};
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new StudentRunnable(names[i]));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All students finished!");
    }
}
