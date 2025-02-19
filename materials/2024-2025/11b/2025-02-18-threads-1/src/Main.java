public class Main {
    public static class MyThread extends  Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "My thread is running!");
            super.run();
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "My runnable is running!");
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("Interrupted my sleep :(");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new MyThread();
        t1.start();
//        t1.run();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().run();

        new Thread(new MyRunnable()).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "My lambda is running!");
        }).start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}