import java.util.List;

public abstract class RobotModule {
    public final String type;
    public final String serial;
    public final String id;

    public RobotModule(String type, String serial, String id) {
        this.type = type;
        this.serial = serial;
        this.id = id;
    }

    @Override
    public String toString() {
        return "RobotModule{" +
                "type='" + type + '\'' +
                ", serial='" + serial + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public abstract void processCommand(String command);

    public abstract boolean isMinimumRequirementCovered(List<RobotModule> rest);
}
