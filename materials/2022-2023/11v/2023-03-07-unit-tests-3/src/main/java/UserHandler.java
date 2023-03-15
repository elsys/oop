import java.util.LinkedList;
import java.util.List;

public class UserHandler {
    public List<String> users = new LinkedList<String>();

    public boolean createUser(
            String username,
            String password
    )throws RuntimeException {
        if(users.contains(username)) return false;

        if(username.equals("ERROR USER"))
            throw new RuntimeException("Failed to connect to database");

        return true;
    }
}
