import java.util.LinkedList;
import java.util.List;

public class Main {
    public static int value = 0;

    public static Object myLock = new Object();

    public synchronized static int getValue() {
        return value;
    }

    public synchronized static void setValue(int value) {
        Main.value = value;
    }

    public synchronized  static void incrementValue() {
//        value++;
        int tmp = getValue();
        tmp++;
        setValue(tmp);
    }

    public static void incrementValue2() {
//        synchronized (this) {
        synchronized (myLock) {
//        value++;
            int tmp = getValue();
            tmp++;
            setValue(tmp);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new LinkedList<>();
        for(int j = 0; j < 100; j++)
            threads.add(new Thread(() -> {
                for(int i = 0; i < 10000; i++) {
//                    Main.value++;
//                    int tmp = Main.getValue();
//                    tmp++;
//                    Main.setValue(tmp);
                    synchronized (Main.myLock) {
                        Main.incrementValue2();
                    }
                }
            }));

        for(Thread t : threads) t.start();
        for(Thread t : threads) t.join();

        System.out.println(value);
    }
}