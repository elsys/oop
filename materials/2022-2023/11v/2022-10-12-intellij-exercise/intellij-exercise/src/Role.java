public class Role {
    private String name;
    private Module[] modules;

    public String getName() {
        return name;
    }

    public Module[] getModules() {
        return modules;
    }

    public Role(String name, Module[] modules) {
        this.name = name;
        this.modules = modules;
    }

    public String[] getActions() {
        String[] actions = new String[0];

        for(int i = 0; i < modules.length; i++) {
            Module m = modules[i];
            String[] newActions = m.getActions();
            String[] tmp = actions;
            actions = new String[actions.length + newActions.length];
            System.arraycopy(tmp, 0, actions, 0, tmp.length);
            System.arraycopy(newActions, 0, actions, tmp.length, newActions.length);
        }

        return actions;
    }
}
