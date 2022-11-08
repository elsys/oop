import java.util.List;
import java.util.Vector;

public class FootballTeam extends Team {
    //private Vector<String> positions;
    private class PlayerTuple {
        public FootballPlayer player;
        public String position;

        public PlayerTuple(FootballPlayer player, String position) {
            this.player = player;
            this.position = position;
        }
    }

    private List<PlayerTuple> players;

    @Override
    protected void addPlayer(Player p) {
        //players.add(p);
    }

    public void addPlayer(FootballPlayer p, String position) {
        players.add(new PlayerTuple(p, position));
    }
}
