import java.util.LinkedList;
import java.util.List;

public class GameEntity {
    private static int instanceCount = 0;
    private static List<String> usedNames = new LinkedList<>();
    private static void validateName(String name) {
        if(usedNames.contains(name))
            throw new IllegalArgumentException("Name already used");
    }

    protected int x = 0;
    protected int y = 0;
    protected String name;

    public GameEntity(int x, int y, String name) {
        validateName(name);

        this.x = x;
        this.y = y;
        this.name = name;

        usedNames.add(name);
    }

    public GameEntity() {
        name = instanceCount + "";

        validateName(name);
        usedNames.add(name);
        instanceCount++;
    }
}
