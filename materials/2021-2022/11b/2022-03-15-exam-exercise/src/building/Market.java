package building;

import main.Player;

public class Market extends AbstractBuilding {
    public Market(String name, String id) {
        super(name, id);
    }

    @Override
    public void update(Player player) {
        player.addResource("gold", (int) (player.getResources().get("gold") * 0.02));
    }
}
