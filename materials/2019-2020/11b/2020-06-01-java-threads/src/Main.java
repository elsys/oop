import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello");

        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Thread.activeCount());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye");*/

        SharedBall ball = new SharedBall();

        /*Thread player1 = new Thread(new Player(ball, 1));
        Thread player2 = new Thread(new Player(ball, -2));

        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Executor executor = Executors.newScheduledThreadPool(2);
        executor.execute(new Player(ball, 1));
        executor.execute(new Player(ball, -2));
        executor.execute(new Player(ball, 3));
    }
}
