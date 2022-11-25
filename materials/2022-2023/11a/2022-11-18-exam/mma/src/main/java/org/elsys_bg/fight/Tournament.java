package org.elsys_bg.fight;

import java.util.*;

public class Tournament {
    private List<Participant> participants = new LinkedList<>();
    private String name;

    public Tournament(String name) {
        this.name = name;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant) {
        participant.setId(participants.size());
        participants.add(participant);
    }

    public void start() throws Exception {
        System.out.println("Tournament is starting");
        if (participants.size() <= 1) {
            throw new Exception("Not enough participants");
        }
        Queue<Participant> group1 = new LinkedList<>();
        Queue<Participant> group2 = new LinkedList<>();

        splitInGroups(group1, group2);

        groupFight(group1, group2);

        determineWinner(group1, group2);
    }

    void groupFight(Queue<Participant> group1, Queue<Participant> group2) {
        while (group1.size() > 0 && group2.size() > 0) {
            Participant participant1 = group1.poll();
            Participant participant2 = group2.poll();
            Participant winner = fight(participant1, participant2);
            if(winner == participant1) {
                participant1.resetHealth();
                System.out.println("Winner: " + participant1);
                group1.add(participant1);
            } else {
                participant2.resetHealth();
                System.out.println("Winner: " + participant2);
                group2.add(participant2);
            }
        }
    }

    void splitInGroups(Queue<Participant> group1, Queue<Participant> group2) {
        var iterator = participants.iterator();
        while (iterator.hasNext()) {
            group1.add(iterator.next());
            if (iterator.hasNext()) {
                group2.add(iterator.next());
            }
        }
    }

    private static void determineWinner(Queue<Participant> group1, Queue<Participant> group2) {
        if(group1.size() > 0) {
            System.out.println("Tournament Winner: " + group1.poll());
        } else {
            System.out.println("Tournament Winner: " + group2.poll());
        }
    }

    Participant fight(Participant participant1, Participant participant2) {
        while (!participant1.isKnockedOut() && !participant2.isKnockedOut()) {
            System.out.println(participant1 + " is attacking " + participant2);
            participant1.attack(participant2);
            if(!participant2.isKnockedOut()) {
                System.out.println(participant2 + " is attacking " + participant1);
                participant2.attack(participant1);
            }
        }

        return participant1.isKnockedOut() ? participant2 : participant1;
    }
}
