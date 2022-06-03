public class Main {
//    private static class MyThread extends Thread {
//        public MyThread(String name) {
//            super(name);
//        }
//
//        @Override
//        public void run() {
//            System.out.println("I am a thread");
//            System.out.println(Thread.currentThread().getName());
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Main thread is " + Thread.currentThread().getName());
       // Thread t = new MyThread("MyThread");
        /*Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am the thread");
            }
        });*/
        /*Thread t = new Thread(() -> {
            System.out.println("I am the thread");
            System.out.println(Thread.currentThread().getName());
        });

//        t.run();
        t.start();

//        t.stop();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Warehouse wh = new Warehouse();
        Producer p1 = new Producer(wh);
        Producer p2 = new Producer(wh);
        Producer p3 = new Producer(wh);
        Producer p4 = new Producer(wh);

        Thread whThread = new Thread(wh);
        Thread p1Thread = new Thread(p1);
        Thread p2Thread = new Thread(p2);
        Thread p3Thread = new Thread(p3);
        Thread p4Thread = new Thread(p4);

        whThread.start();
        p1Thread.start();
        p2Thread.start();
        p3Thread.start();
        p4Thread.start();

        try {
            whThread.join();
            p1Thread.join();
            p2Thread.join();
            p3Thread.join();
            p4Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
