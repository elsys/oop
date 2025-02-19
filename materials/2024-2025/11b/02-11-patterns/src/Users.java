import java.util.LinkedList;
import java.util.List;

public class Users {
    private List<Object> users = new LinkedList<>();

    public void deleteUser() {}

    public void printToCOnsole() {}

    public void printToFile() {}
}


public class UsersList {
    private List<Object> users = new LinkedList<>();

    public void addUser(){}
    public void removeUser(){}
}

public class UsersHandler {
    private UsersList users;

    public UsersHandler(UsersList users) {
        this.users = users;
    }

    public void deleteUser() {
        // 1. find user
        // 2. remove from list
        users.removeUser(??);
    }
}

public class UsersRenderer {
    private UsersList users;

    public UsersRenderer(UsersList users) {
        this.users = users;
    }

    public void printToCOnsole() {}

    public void printToFile() {}
}