public class Main {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("In thread");

            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread done");
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() +
                    " In thread");

            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() +
                    " Thread done");
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() +
                " Before creating thread");
//        Thread t1 = new MyThread();
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("In thread");
//
//                try {
//                    Thread.sleep(3 * 1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                System.out.println("Thread done");
//            }
//        };
//        Thread t1 = new Thread(new MyRunnable());
//        Thread t1 = new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() +
//                        " In thread");
//
//                try {
//                    Thread.sleep(3 * 1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                System.out.println(Thread.currentThread().getName() +
//                        " Thread done");
//        });

//        System.out.println(Thread.currentThread().getName() +
//                " Before starting thread");
//        t1.start();
//
//        try {
//            System.out.println(Thread.currentThread().getName() +
//                    " Before joining thread");
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName() +
//                " After join");

        Thread[] threads = new Thread[10];
        for(int i =0; i < 9; i++)
            threads[i] = new Thread(new MyRunnable());

        threads[9] = new Thread(() -> {
           while(true);
        });

        for(int i =0; i < 10; i++)
            threads[i].start();

        try {
            for(int i =0; i < 10; i++) {
                threads[i].join(5000);
                threads[i].stop();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
