package buildable;

import building.AbstractBuilding;
import building.Goldmine;
import main.Player;

public class BuildableMine extends AbstractBuildable {
    public BuildableMine() {
        super("Mine", "0003");
        requiredResources.put("wood", 100);
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Goldmine(name, id);
    }
}
