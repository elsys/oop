package org.elsys.mbnov.steam;

public class User {
    public String id;
    public String username;
    public String email;

    public User(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
