import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private int currPos = 1;
    private String driver;
    private int currLap = 1;
    private int segmentCount;
    private List<Float> currLapTimes;
    private List<Float> allLapTimes = new LinkedList<>();
    private int currSegment = 0;
    private int targetLaps;
    private ITrackAccess track;

    public void setTrack(ITrackAccess track) {
        this.track = track;
    }

    public void setTargetLaps(int targetLaps) {
        this.targetLaps = targetLaps;
    }

    public void setCurrPos(int currPos) {
        this.currPos = currPos;
    }

    public int getCurrLap() {
        return currLap;
    }

    public int getCurrSegment() {
        return currSegment;
    }

    public Car(String driver, int segmentCount) {
        this.segmentCount = segmentCount;
        this.driver = driver;
        currLapTimes = new ArrayList<>(segmentCount);
        for(int i=0; i<segmentCount; i++) {
            currLapTimes.add(0f);
        }
    }

    public void reset() {
        currPos = 1;
        currLap = 1;
        currLapTimes.clear();
        for(int i=0; i<segmentCount; i++) {
            currLapTimes.add(0f);
        }
        allLapTimes.clear();
        currSegment = 0;
    }

    @Override
    public String toString() {
        return "[" + currPos + "] " +
                driver + " " +
                getCurrLapTime() + " " +
                currLap;

//        return "Car{" +
//                "currPos=" + currPos +
//                ", driver='" + driver + '\'' +
//                ", currLap=" + currLap +
//                ", segmentCount=" + segmentCount +
//                ", currLapTimes=" + currLapTimes +
//                ", allLapTimes=" + allLapTimes +
//                '}';
    }

    public float getCurrLapTime() {
//        float a = 0f;
//        for(float t : currLapTimes) {
//            a += t;
//        }
//        return a;

        return currLapTimes.stream()
                .reduce(0f, (a, t) -> a + t);
    }

    public void startRace() {
        //Thread.currentThread().interrupt();
//        currentThread.interrupt();
        lock.notify();
    }

//    private Thread currentThread;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
//        currentThread = Thread.currentThread();
        Random rand = new Random();

        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while(!Thread.interrupted()) {
//            try {
//                Thread.sleep(Long.MAX_VALUE);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        try {
            while(currLap < targetLaps) {
                float segmentTime = rand.nextFloat() * track.get(currSegment);
                Thread.sleep((long) (segmentTime * 100));
                currLapTimes.set(currSegment, segmentTime);
                currSegment++;

                if(currSegment >= segmentCount) {
                    currLap++;
                    currSegment = 0;
                    allLapTimes.add(getCurrLapTime());
                    currLapTimes.clear();
                    for(int i=0; i<segmentCount; i++) {
                        currLapTimes.add(0f);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static interface ITrackAccess {
        float get(int i);
    }
}
