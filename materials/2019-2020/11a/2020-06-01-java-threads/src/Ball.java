public class Ball {
    private float x = 0;
    private float y = 0;

    private Object lockX = new Object();
    private Object lockY = new Object();

    public float getX() {
        synchronized (lockX) {
            return x;
        }
    }

    public synchronized float getY() {
        return y;
    }

    public void setX(float x) {
        synchronized(lockX) {
            this.x = x;
        }
        System.out.println("I just updated the X!");
    }

    public void setY(float y) {
        this.y = y;
    }
}
