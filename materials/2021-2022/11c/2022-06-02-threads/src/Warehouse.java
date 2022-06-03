public class Warehouse implements Runnable {
    private int boxesCount = 0;

    synchronized public int getBoxesCount() {
        return boxesCount;
    }

    synchronized public void setBoxesCount(int boxesCount) {
        this.boxesCount = boxesCount;
    }

    @Override
    public void run() {
        System.out.println("Warehouse started");
        while(getBoxesCount() < 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Warehouse ended");
    }
}
