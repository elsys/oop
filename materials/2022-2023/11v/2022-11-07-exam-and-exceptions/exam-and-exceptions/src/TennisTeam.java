public class TennisTeam extends Team {
    @Override
    public void addPlayer(Player p) {
        if(players.size() >= 1)
            throw new IllegalArgumentException("Tennis team can only have 1 player");

        players.add(p);
    }
}
