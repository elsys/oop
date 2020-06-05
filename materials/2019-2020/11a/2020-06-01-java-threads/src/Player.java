import javax.swing.plaf.TableHeaderUI;

public class Player implements Runnable {
    private final Ball ball;
    private final int direction;

    public Player(Ball ball, int direction) {
        this.ball = ball;
        this.direction = direction;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (ball) {
                ball.setX(ball.getX() + direction);
                System.out.println(Thread.currentThread().getName() + " kicked the ball to " + ball.getX());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
