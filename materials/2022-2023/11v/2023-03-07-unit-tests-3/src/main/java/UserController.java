public class UserController {
    public UserHandler userHandler;

    public boolean createUser(String username, String password) {
        if(username.length() < 5) return false;
        if(password.length() < 4) return false;

        boolean res =
                userHandler.createUser(username, password);

        return res;
    }
}
