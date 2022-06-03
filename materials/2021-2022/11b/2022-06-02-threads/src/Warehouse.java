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
        System.out.println("Warehouse start");

        while(getBoxesCount() < 100) {
        /*while(true){
            synchronized (this) {
                if(getBoxesCount() >= 100) break;
            }*/
            System.out.println("Warehouse not full yet");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Warehouse end");
    }
}
