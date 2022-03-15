package buildable;

import building.AbstractBuilding;
import building.Sawmill;
import main.Player;

public class BuildableMill extends AbstractBuildable {
    public BuildableMill() {
        super("Sawmill", "0004");
        requiredResources.put("wood", 100);
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Sawmill(name, id);
    }
}
