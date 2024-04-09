import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Judge implements Runnable {
    private Queue<Player> players;
    private int targetNum;
    private int lastGuess;
    private int minNum;
    private int maxNum;

    synchronized int getMinNum() {
        return minNum;
    }

    synchronized int getMaxNum() {
        return maxNum;
    }

    private void initRound() {
        minNum = 0;
        maxNum = 100;
        targetNum = new Random().nextInt(100);
    }

    @Override
    public void run() {
        try {
            initRound();

    //        while(true) {
            for(;;) {
                Player currPlayer = players.remove();

                synchronized (currPlayer) {
                    currPlayer.notify();
                }
                synchronized (this) {
                    this.wait();
                }

                players.add(currPlayer);

                if(lastGuess == targetNum) {
                    break;
                } else {
                    updateBounds();
                }
            }
    //        TODO: Remove random player, excluding the correct guesser


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateBounds() {
//        TODO: Implement
    }
}
