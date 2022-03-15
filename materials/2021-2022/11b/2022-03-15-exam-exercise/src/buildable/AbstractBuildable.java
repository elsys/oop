package buildable;

import building.AbstractBuilding;
import main.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBuildable {
    protected String name;
    protected String id;
    protected Map<String, Integer> requiredResources = new HashMap<>();

    public AbstractBuildable(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getRequiredResources() {
        return requiredResources;
    }

    public boolean isLocked(Player player) {
        return false;
    }

    public boolean canBuild(Player player) {
        // Return false if there aren't enough resources
        Map<String, Integer> currentResources = player.getResources();
        for (String k : requiredResources.keySet()) {
            for (String kk : currentResources.keySet()) {
                if (k == kk && requiredResources.get(k) > currentResources.get(kk)) return false;
            }
        }

        // Return false if the building is locked
        return !isLocked(player);
    }

    public abstract AbstractBuilding build(Player player) throws Exception;
}
