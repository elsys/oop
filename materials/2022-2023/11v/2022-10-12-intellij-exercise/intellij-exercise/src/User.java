public class User {
    String username;
    private String email;
    Role[] roles;

    public String getEmail() {
        return email;
    }

    public User(String username, String email, Role[] roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String[] getActions() {
        String[] actions = new String[0];

        for(int i = 0; i < roles.length; i++) {
            Role m = roles[i];
            String[] newActions = m.getActions();
            String[] tmp = actions;
            actions = new String[actions.length + newActions.length];
            System.arraycopy(tmp, 0, actions, 0, tmp.length);
            System.arraycopy(newActions, 0, actions, tmp.length, newActions.length);
        }

        return actions;
    }

//    public static void main(String[] args) {
//        String[] actions1 =
//        Module m1 = new Module("module1", );
//    }
}
