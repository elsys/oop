public class Main {
    private static class Worker implements Runnable {
        private Summer summer;

        public Worker(Summer summer) {
            this.summer = summer;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                summer.add(1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
//        Summer summer = new Summer();
//        Thread t1 = new Thread(summer);
//        t1.start();
//
//        for(int i = 0; i < 10; i++) {
//            Worker w1 = new Worker(summer);
//            Thread t2 = new Thread(w1);
//            t2.start();
//        }

        Ping ping = new Ping();
        Pong pong = new Pong();

        ping.pong = pong;
        pong.ping = ping;

        new Thread(pong).start();
        new Thread(ping).start();
    }
}
