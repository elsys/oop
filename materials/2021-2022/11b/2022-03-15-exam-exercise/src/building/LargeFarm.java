package building;

import main.Player;

public class LargeFarm extends AbstractBuilding {
    public LargeFarm(String name, String id) {
        super(name, id);
    }

    @Override
    public void update(Player player) {
        player.addResource("food", 20);
    }
}
