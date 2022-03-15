package building;

import main.Player;

public class Sawmill extends AbstractBuilding {
    public Sawmill(String name, String id) {
        super(name, id);
    }

    @Override
    public void update(Player player) {
        player.addResource("wood", 10);
    }
}
