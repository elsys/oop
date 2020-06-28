import java.util.List;

public class Player implements Runnable {
    private Game game;
    public String name;

    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            while(true) {
                synchronized (this) {
                    wait();
                }

                System.out.println("[" + name + "] Start turn");
                int move = Die.roll();
                System.out.println("[" + name + "] Rolled " + move);
                int boardPosition = game.board.indexOf(this);
                int newPosition = (boardPosition + move) % game.board.size();
                System.out.println("[" + name + "] Will move from " + boardPosition + " to " + newPosition);

                game.board.set(boardPosition, null);
                if (game.board.get(newPosition) != null) {
                    System.out.println("[" + name + "] There is already a player there");
                    game.removePlayer(game.board.get(newPosition));
                }
                game.board.set(newPosition, this);

                System.out.println("[" + name + "] Turn finished");
                game.finishTurn(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
