package org.elsys_bg.hash;

import java.util.Objects;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /*
    hash code - number representation of your data
    when 2 objects are equals they must return same hash code
    2 different objects doesn't necessary return different hash codes
     */
//    @Override
//    public int hashCode() {
//          return 1; valid but not good
//        return Objects.hash(id, name, email);
//    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        return result;
//    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(id, o.id) * -1;
    }
}
