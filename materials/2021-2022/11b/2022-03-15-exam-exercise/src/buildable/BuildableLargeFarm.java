package buildable;

import building.AbstractBuilding;
import building.LargeFarm;
import main.Player;

public class BuildableLargeFarm extends AbstractBuildable {
    public BuildableLargeFarm() {
        super("Large farm", "0008");
        requiredResources.put("wood", 100);
        requiredResources.put("stone", 50);
    }

    @Override
    public boolean isLocked(Player player) {
        boolean hasMarket = false;
        for (AbstractBuilding b : player.getBuildings()) {
            if (b.getId() == "0007") hasMarket = true;
        }

        return !hasMarket;
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new LargeFarm(name, id);
    }
}
