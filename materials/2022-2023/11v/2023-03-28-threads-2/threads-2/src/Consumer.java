public class Consumer implements Runnable {
    private Producer prod;

    public Consumer(Producer prod) {
        this.prod = prod;
    }

    @Override
    public void run() {
        while(true) {
            int val = prod.getVal();
            System.out.println(
                    Thread.currentThread().getName() + ": " + val
            );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
