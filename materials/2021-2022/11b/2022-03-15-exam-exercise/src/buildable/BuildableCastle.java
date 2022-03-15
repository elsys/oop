package buildable;

import building.AbstractBuilding;
import building.Castle;
import main.Player;

public class BuildableCastle extends AbstractBuildable {
    public BuildableCastle() {
        super("Castle", "0006");
        requiredResources.put("wood", 200);
        requiredResources.put("stone", 200);
        requiredResources.put("gold", 100);
    }

    @Override
    public boolean isLocked(Player player) {
        boolean hasTower = false;
        for (AbstractBuilding b : player.getBuildings()) {
            if (b.getId() == "0005") hasTower = true;
        }

        return !hasTower;
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Castle(name, id);
    }
}
