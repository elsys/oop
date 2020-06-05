import javax.sound.midi.Soundbank;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello");
        try {
            System.out.println(Thread.activeCount());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye");*/

        System.out.println("Main " + Thread.currentThread());
        /*Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread hello");
                System.out.println("Child " + Thread.currentThread());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread goodbye");
            }
        });*/

        Ball ball = new Ball();
//        Thread thread1 = new Thread(new Player(ball, 1));
//        Thread thread2 = new Thread(new Player(ball, -1));
//
//        thread1.start();
//        thread2.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(new Player(ball, 1));
        executor.execute(new Player(ball, -1));
        executor.execute(new Player(ball, -2));
    }
}
