package org.elsys;

import java.util.*;

public class Sect {

    private Member leader;

    private String name;

    private List<Member> members;

    public Sect(Member leader, String name, List<Member> members) {
        this.leader = leader;
        this.name = name;
        this.members = members;
    }

    public Map<String, List<Member>> getMembersByRank() {
        // TODO
        return null;
    }

    public List<Member> getMembersOrderBySubscription() {
        ArrayList<Member> sorted = new ArrayList<>(members);
        sorted.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.getSubscription() < o2.getSubscription()) {
                    return 1;
                } else if (o1.getSubscription() > o2.getSubscription()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return sorted;
    }

    public Member getLeader() {
        return leader;
    }

    public void setLeader(Member leader) {
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sect sect = (Sect) o;
        return Objects.equals(leader, sect.leader) &&
                Objects.equals(name, sect.name) &&
                Objects.equals(members, sect.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leader, name, members);
    }
}
