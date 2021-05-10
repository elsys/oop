import java.util.List;

public abstract class RobotModule {
    public final String type;
    public final String serialNumber;
    public final String id;

    public RobotModule(String type, String serialNumber, String id) {
        this.type = type;
        this.serialNumber = serialNumber;
        this.id = id;
    }

    @Override
    public String toString() {
        return "RobotModule{" +
                "type='" + type + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    abstract void processCommand(String command) throws Exception;

    abstract boolean isMinimumRequirementCovered(List<RobotModule> rest);
}
