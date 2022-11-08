import java.util.ArrayList;
import java.util.List;

public abstract class Team {
    protected String name;
    protected List<Player> players = new ArrayList<>();

    protected abstract void addPlayer(Player p);
}
