public class Main {
    static class Filler implements Runnable {
        private Chushkopek cp;

        public Filler(Chushkopek cp) {
            this.cp = cp;
        }

        @Override
        public void run() {
            for(int i=0; i<5; i++) {
                System.out.println(Thread.currentThread().getName() + " Added a chushka");
                cp.addChushka();
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("iter count is " + cp.iterCount);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main is running");
//        Thread t = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("I am the thread");
////            }
////        });
        /*Thread t = new Thread(() ->
            System.out.println("I am the lambda")
        );*/
        Chushkopek cp = new Chushkopek(5);
        Thread  t = new Thread(cp);
        //Thread t = new Chushkopek();
        t.start();

        for(int i=0; i<10; i++) {
            Thread f = new Thread(new Filler(cp), "Filler-" + i);
            f.start();
        }

        Thread grabber = new Thread(() -> {
           while(true) {
               cp.removeChushka();
               try {
                   Thread.sleep(1500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        grabber.start();

        System.out.println("I created a thread");
    }
}
