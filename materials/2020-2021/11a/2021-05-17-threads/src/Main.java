import javax.swing.plaf.TableHeaderUI;

public class Main {
    private static class SteakSource implements Runnable {
        private Skara skara;

        public SteakSource(Skara skara) {
            this.skara = skara;
        }

        @Override
        public void run() {
            for(int i=0; i<5; i++) {
                skara.addSteak();
                System.out.println(
                Thread.currentThread().getName() + " I added a steak!"
                );
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main is running");
//        Thread t = new Thread();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("The thread is running");
//            }
//        });
//        Thread t = new Thread(() -> {
//            try {
//                Thread.sleep(10 * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("The thread is running");
//        });
        Skara skara = new Skara(15);
        Thread t = new Thread(skara);
        //Thread t = new Skara();
        t.start();
//        t.stop();
//        t.interrupt();
//        t.join();

        for(int i=0; i<10; i++) {
            Thread ss = new Thread(new SteakSource(skara), "Cow-"+(i+1));
            ss.start();
        }

        (new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(3 * 1000);
                    skara.removeSteak();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).start();

        System.out.println("Main finished");
    }
}
