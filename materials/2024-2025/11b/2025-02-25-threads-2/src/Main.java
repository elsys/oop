public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started");

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted 1");
            }
//            try {
//                Thread.sleep(1000 * 1000);
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + " interrupted 2");
//            }
            while(true) {
                System.out.println("HI");
                if(Thread.interrupted()) {
                    break;
                }
            }

            System.out.println(Thread.currentThread().getName() + " finished");
        });

        t1.start();
        try {
            t1.join(5 * 1000);
            if(t1.isAlive()) {
                System.out.println("Thread is alive");
                t1.interrupt();
                t1.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}