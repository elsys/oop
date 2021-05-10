import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Robot {
    private String name;
    private String serialNumber;
    private int maxModules;
    private List<RobotModule> modules = new ArrayList();

    public Robot(String name, String serialNumber, int maxModules) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.maxModules = maxModules;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getMaxModules() {
        return maxModules;
    }

    public List<RobotModule> getModules() {
        return modules;
    }

    void addModule(RobotModule newModule) throws Exception {
        if(modules.size() >= maxModules)
            throw new Exception("Max modules reached");

        if(modules.contains(newModule))
            throw new Exception("Module already added");

        modules.add(newModule);
    }

    boolean isMinimumRequirementCovered() {
        long heads = 0, arms = 0, legs = 0;
        /*for(RobotModule m : modules) {
            if(m instanceof RobotHead) heads++;
            //if(m instanceof RobotArm) arms++;
            //if(m instanceof RobotLeg) legs++;
        }*/

        // TODO: Implement with a single stream
        heads = modules.stream()
                .filter((m) -> m instanceof RobotHead)
                .count();
        /*arms = modules
                .stream()
                .filter((m) -> m instanceof RobotArm)
                .count();
        legs = modules
                .stream()
                .filter((m) -> m instanceof RobotLeg)
                .count();*/

        if(!(heads >= 1 && arms >= 2 && legs >= 1)) return false;

        return modules
                .stream()
                .allMatch((m) -> m.isMinimumRequirementCovered(
                        modules
                                .stream()
                                .filter((m2) -> m2 != m)
                                .collect(Collectors.toList())
                ));
        /*for(RobotModule m : modules) {
            if(!m.isMinimumRequirementCovered(
                    modules
                            .stream()
                            .filter((m2) -> m2 != m)
                            .collect(Collectors.toList())
            ))
                return false;
        }
        return true;*/
    }

    void processCommand(String command) {
        // TODO: Implement
    }
}
