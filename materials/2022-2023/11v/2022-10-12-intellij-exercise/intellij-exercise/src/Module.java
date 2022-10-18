public class Module {
    private String name;
    private String[] actions;

    public String getName() {
        return name;
    }

    public String[] getActions() {
        return actions;
    }

    public Module(String name, String[] actions) {
        this.name = name;
        this.actions = actions;
    }
}
