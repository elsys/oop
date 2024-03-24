public class Summer implements Runnable {
    private int sum = 0;

//    public synchronized void add(int a) {
////        System.out.println(
////            Thread.currentThread().getName() + " called add(" + a + ")" + " and sum = " + sum
////        );
//        sum += a;
//    }

    private Object bar = new Object();

    public void add(int a) {
        synchronized(bar) {
            sum += a;
        }
    }

    public synchronized void foo() {
        System.out.println("Foo");
        baz();
    }

    public synchronized void baz() {
        System.out.println("Baz");

        synchronized(bar) {
            System.out.println("Inside synchronized");
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }

        System.out.println("Result: " + sum);
    }
}
