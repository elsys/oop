package building;

import main.Player;

public class Farm extends AbstractBuilding {
    public Farm(String name, String id) {
        super(name, id);
    }

    @Override
    public void update(Player player) {
        player.addResource("food", 10);
    }
}
