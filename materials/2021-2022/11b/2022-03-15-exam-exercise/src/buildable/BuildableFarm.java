package buildable;

import building.AbstractBuilding;
import building.Farm;
import main.Player;

public class BuildableFarm extends AbstractBuildable {
    public BuildableFarm() {
        super("Farm", "0001");
        requiredResources.put("wood", 60);
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Farm(name, id);
    }
}
