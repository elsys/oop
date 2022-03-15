package building;

import main.Player;

public class Goldmine extends AbstractBuilding {
    public Goldmine(String name, String id) {
        super(name, id);
    }

    @Override
    public void update(Player player) {
        player.addResource("gold", 10);
    }
}
