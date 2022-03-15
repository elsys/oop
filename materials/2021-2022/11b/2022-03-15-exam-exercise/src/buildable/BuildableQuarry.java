package buildable;

import building.AbstractBuilding;
import building.Quarry;
import main.Player;

public class BuildableQuarry extends AbstractBuildable {
    public BuildableQuarry() {
        super("Quarry", "0002");
        requiredResources.put("wood", 100);
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Quarry(name, id);
    }
}
