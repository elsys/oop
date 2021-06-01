import java.util.ArrayList;
import java.util.List;

public class AmazonWarehouse implements Runnable {
    private List<Integer> packages = new ArrayList<>();

    public void addPackage(int weight) {
        System.out.println("Adding package " + weight);
        packages.add(weight);
        System.out.println("Package count is " + packages.size());
    }

    @Override
    public void run() {
        //try {
            try {
                while (true) {
                    Thread.sleep(1 * 1000);
                    System.out.println("The warehouse is alive");
                }
            } catch (InterruptedException e) {
                System.out.println("Inner catch 1");
                e.printStackTrace();
            }

            //Thread.sleep(1000);
            /*for(int i=0; i<65000; i++) {
                System.out.println(i);
//                if(Thread.interrupted()) break;
                //if(Thread.interrupted()) throw new InterruptedException();
                if(Thread.currentThread().isInterrupted()) throw new InterruptedException();
            }*/

            try {
                while (true) {
                    Thread.sleep(1 * 1000);
                    System.out.println("Sending package");
                }
            } catch (InterruptedException e) {
                System.out.println("Inner catch 2");
                e.printStackTrace();
            }
        /*} catch (InterruptedException e) {
            System.out.println("Outer catch");
            e.printStackTrace();
        }*/
    }
}
