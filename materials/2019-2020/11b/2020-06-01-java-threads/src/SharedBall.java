import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBall {
    private float x = 0;
    private float y = 0;

    private Lock lockX = new ReentrantLock();
    private Object lockY = new Object();

    //public synchronized void setX(float x) {
    public void setX(float x) {
        //synchronized (this) {
        synchronized (lockX) {
            this.x = x;
        }
        System.out.println("Set X called");
    }

    public float getX() {
        synchronized (lockX) {
            return x;
        }
    }
}
