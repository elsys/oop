package building;

import main.Player;

public class Quarry extends AbstractBuilding {
    public Quarry(String name, String id) {
        super(name, id);
    }

    @Override
    public void update(Player player) {
        player.addResource("stone", 10);
    }
}
