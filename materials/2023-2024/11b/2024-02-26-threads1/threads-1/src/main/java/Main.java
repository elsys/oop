public class Main {
    public static class Mythread extends Thread {
        @Override
        public void run() {
            System.out.println(
                    Thread.currentThread().getName() +
                    ": Mythread is running"
            );

            try {
                Thread.sleep(100000 * 100000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
//            while(true) {}
        }
    }

    public static class MyRunnable implements Runnable {
        private int val = 5;
        @Override
        public void run() {
            System.out.println(
                    Thread.currentThread().getName() + ": My lambda thread"
            );
        }
    }

    public static void main(String[] args) {
        System.out.println(
                Thread.currentThread().getName() + ": Main start"
        );

//        Thread t1 = new Mythread();
////        t1.run();
//        t1.start();
//
//        for(int i = 0; i < 5; i++ ) {
//            Thread tn = new Mythread();
//            tn.start();
//        }
//        try {
////            t1.wait();
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Thread t2 = new Thread(() -> {
            System.out.println(
                    Thread.currentThread().getName() + ": My lambda thread"
            );
        });
        Thread t3 = new Thread(new Runnable() {
            private int val = 5;
            private void printVal() {
                System.out.println(val);
            }
            @Override
            public void run() {
                System.out.println(
                        Thread.currentThread().getName() + ": My lambda thread"
                );
            }
        });
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        }

        for(int i = 0; i < 5; i++ ) {
            Thread tn = new Thread(new MyRunnable());
            tn.start();
        }

        System.out.println(
                Thread.currentThread().getName() + ": Main end"
        );
    }
}
