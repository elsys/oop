package org.elsys;

import java.util.Objects;

public class Member {

    private String name;

    private String rank;

    private double subscription;

    public Member(String name, double subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSubscription() {
        return subscription;
    }

    public void setSubscription(double subscription) {
        this.subscription = subscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Double.compare(member.subscription, subscription) == 0 &&
                Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscription);
    }
}
