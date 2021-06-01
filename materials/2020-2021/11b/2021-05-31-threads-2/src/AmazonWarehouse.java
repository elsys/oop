import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AmazonWarehouse implements Runnable {
    private List<Integer> packages = new ArrayList<>();

    private ReadWriteLock packageLock = new ReentrantReadWriteLock();
    private ReentrantLock lock = new ReentrantLock();
    private Semaphore multipleLock = new Semaphore(8);

    private boolean acceptPackages = true;

    public void addPackage(int weight) {
        if(!acceptPackages) return;

        try {
            multipleLock.acquire();
            //packageLock.writeLock().lock();
            //lock.lock();
            try {
                System.out.println("Add package with weight " + weight);
                packages.add(weight);
                System.out.println("Package count is " + packages.size());
            } finally {
                //lock.unlock();
                //packageLock.writeLock().unlock();
            }
            //packageLock.writeLock().unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            multipleLock.release();
        }

    }

    public int getPackageCount() {
        packageLock.readLock().lock();
        try {
            return packages.size();
        } finally {
            packageLock.readLock().unlock();
        }

        /*if(packageLock.readLock().tryLock()) {
            packageLock.readLock().unlock();
            return packages.size();
        }
        return 0;*/
    }

    @Override
    public void run() {
        try {
            try {
                while (true) {
                    Thread.sleep(1 * 1000);
                    System.out.println("The warehouse is still here");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            acceptPackages = false;

            /*for(int i=0; i< 6500000; i++ ) {
                System.out.println(i);
                if(Thread.interrupted()) break;
                if(Thread.currentThread().isInterrupted()) break;
            }*/

            try {
                while (true) {
                    Thread.sleep(1 * 1000);
                    packages.remove(0);
                    System.out.println("Sending package");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
