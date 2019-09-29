package org.elsys;

import java.util.Objects;

public final class SectMember {

    private final long id;

    private final int rank;

    private final String name;

    public SectMember(final long id, final int rank, final String name) {
        this.id = id;
        this.rank = rank;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectMember that = (SectMember) o;
        return id == that.id &&
                rank == that.rank &&
                Objects.equals(name, that.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, rank, name);
    }

    @Override
    public String toString() {
        return "SectMember{" +
                "id=" + id +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }
}
