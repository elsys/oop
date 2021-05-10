import java.util.List;

public class RobotHead extends RobotModule {
    final List<String> sensors;
    boolean hasDepthVision;
    private int rotation = 0;

    public RobotHead(String serial, String id, List<String> sensors) {
        super("head", serial, id);
        this.sensors = sensors;

        // TODO: Implement with streams
        this.hasDepthVision = false;

        for(String sensor : sensors) {
            if(sensors.lastIndexOf(sensor) !=
                    sensors.indexOf(sensor)) {
                this.hasDepthVision = true;
            }
        }
    }


    @Override
    public void processCommand(String command) {
        // "rotate_left 45"
        // "rotate_right 30"
        // TODO: Implement error checks
        String[] parts = command.split(" ");

        switch (parts[0]) {
            case "rotate_left": {
                System.out.println("Rotate left " + parts[1] + " degrees");
                rotation -= Integer.parseInt(parts[1]);
                break;
            }
            case "rotate_right": {
                System.out.println("Rotate right " + parts[1] + " degrees");
                rotation += Integer.parseInt(parts[1]);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown command");
            }
        }
    }

    @Override
    public boolean isMinimumRequirementCovered(List<RobotModule> rest) {
        return true;
    }
}
