public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from thread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye from thread");
    }
}
