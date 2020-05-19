package org.elsys.duzunov;

import java.util.Objects;

public final class Actor {
    private final String firstName;
    private final String lastName;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Actor [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return getFirstName().equals(actor.getFirstName()) &&
                getLastName().equals(actor.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
