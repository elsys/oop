package buildable;

import building.AbstractBuilding;
import building.Market;
import main.Player;

public class BuildableMarket extends AbstractBuildable {
    public BuildableMarket() {
        super("Market", "0007");
        requiredResources.put("wood", 150);
        requiredResources.put("gold", 100);
    }

    @Override
    public boolean isLocked(Player player) {
        boolean hasFarm = false;
        boolean hasQuarry = false;
        boolean hasMine = false;
        boolean hasMill = false;

        for (AbstractBuilding b : player.getBuildings()) {
            if (b.getId() == "0001") hasFarm = true;
            if (b.getId() == "0002") hasQuarry = true;
            if (b.getId() == "0003") hasMine = true;
            if (b.getId() == "0004") hasMill = true;
        }

        return !hasFarm || !hasQuarry || !hasMine || !hasMill;
    }

    @Override
    public AbstractBuilding build(Player player) throws Exception {
        if (isLocked(player)) throw new Exception(name + " is locked");
        if (!canBuild(player)) throw new Exception(name + " cannot be built");

        return new Market(name, id);
    }
}
