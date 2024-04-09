import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Building extends GameEntity {
    protected List<ResourceType> acceptedTypes;

    protected String type = "";

    protected Building(int x, int y, String type, ResourceType[] resourceTypes) {
        super(x, y, type);

        this.type = type;
        acceptedTypes = Arrays.asList(resourceTypes);
    }

    public class HQ extends Building {
        public HQ(int x, int y) {
            super(
                    x,
                    y,
                    "HQ",
                    new ResourceType[]{ResourceType.GOLD, ResourceType.WOOD}
            );
        }
    }
}
