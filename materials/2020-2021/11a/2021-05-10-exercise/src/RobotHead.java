import java.util.Collections;
import java.util.List;

public class RobotHead extends RobotModule {
    final List<String> sensors;
    final boolean hasDepthVision;
    private int angle = 0;

    public RobotHead(String type, String serialNumber, String id, List<String> sensors) {
        super(type, serialNumber, id);

        this.sensors = sensors;
        /*this.hasDepthVision = sensors
                .stream()
                .anyMatch((s) ->
                        Collections.frequency(sensors, s) > 1
                );*/
        this.hasDepthVision = false;
        for(String s : sensors) {
            if(Collections.frequency(sensors, s) > 1) {
                this.hasDepthVision = true;
                break;
            }
        }

    }

    @Override
    void processCommand(String command) throws Exception {
        // "rotate_left 37"
        // "rotate_right 80"
        // TODO: Check for valid command
        String[] parts = command.split(" ");

        switch (parts[0]) {
            case "rotate_left": {
                System.out.println("Rotate left " + parts[1] + " degrees");
                angle += Integer.parseInt(parts[1]);
                break;
            }
            case "rotate_right": {
                System.out.println("Rotate right " + parts[1] + " degrees");
                angle -= Integer.parseInt(parts[1]);
                break;
            }
            default: {
                throw new Exception("Invalid command");
            }
        }
    }

    @Override
    boolean isMinimumRequirementCovered(List<RobotModule> rest) {
        return true;
    }
}
