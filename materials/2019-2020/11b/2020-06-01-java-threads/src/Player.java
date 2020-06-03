public class Player implements Runnable {
    private final SharedBall ball;
    private final float direction;

    public Player(SharedBall ball, float direction) {
        this.ball = ball;
        this.direction = direction;
    }

    @Override
    public void run() {
        while(true) {
//            synchronized (ball) {
            ball.setX(ball.getX() + direction);
//            }
            System.out.println(Thread.currentThread().getId() + " " + ball.getX());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
