import java.util.Map;

public class TennisPLayer extends Player {
//    private int clayMatches;
//    private int clayWins;
//
//    private Vector<Integer> matches;
//    private Vector<Integer> wins;

    private Map<String, Integer> matches;
    private Map<String, Integer> wins;

    public Map<String, Integer> getMatches() {
        return matches;
    }

    public Map<String, Integer> getWins() {
        return wins;
    }

    public TennisPLayer(String name, int age, String country, int points, Map<String, Integer> matches, Map<String, Integer> wins) {
        super(name, age, country, points);
        this.matches = matches;
        this.wins = wins;
    }

    public TennisPLayer() {
        super("test", 1, "test", 0);
    }
}
