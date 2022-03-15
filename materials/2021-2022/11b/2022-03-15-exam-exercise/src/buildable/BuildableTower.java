package buildable;

import building.AbstractBuilding;
import building.Tower;
import main.Player;

public class BuildableTower extends AbstractBuildable {
    public BuildableTower() {
        super("Tower", "0005");
        requiredResources.put("wood", 100);
        requiredResources.put("stone", 100);
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Tower(name, id);
    }
}
