package building;

public abstract class AbstractBuilding implements IUpdatable {
    protected String name;
    protected String id;

    public AbstractBuilding(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
