import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    List<Player> board = new ArrayList();
    List<Player> players = new ArrayList<>();
    ExecutorService ex;

    public void removePlayer(Player player) {
        System.out.println("Remove player " + player.name);
        players.remove(player);

        if(players.size() == 1) {
            this.endGame();
        }
    }

    private void endGame() {

        ex.shutdownNow();
        System.out.println("The winner is " + players.get(0).name);
    }

    public void finishTurn(Player player) {
        System.out.println("Finish turn for player " + player.name);
        int index = players.indexOf(player) + 1;
        if(index == players.size()) index = 0;

        synchronized (players.get(index)) {
            players.get(index).notify();
        }
    }

    public void run() throws InterruptedException {
        for(int i=0; i< 20; i++) {
            board.add(null);
        }

        for(int i=0; i< 2; i++) {
            Player p = new Player("P" + (i + 1), this);
            board.set(i*5, p);
            players.add(p);
        }

        ex = Executors.newFixedThreadPool(4);
        for (Player player : players) {
            ex.execute(player);
        }

        Thread.sleep(100);
        Player target = players.get(0);
        synchronized (target) {
            target.notify();
        }
    }
}
