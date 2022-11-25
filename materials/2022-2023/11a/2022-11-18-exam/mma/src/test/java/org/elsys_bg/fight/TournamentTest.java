package org.elsys_bg.fight;

import org.elsys_bg.fight.styles.Karate;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TournamentTest {
    Participant participant1;
    Participant participant2;
    Participant participant3;
    Tournament tournament;

    Queue<Participant> group1;
    Queue<Participant> group2;
    final int maxHealth = 100;
    int tSize;

    @BeforeEach
    void setUp()
    {
        participant1 = new Karate("jasenStatem", 10, maxHealth);
        participant2 = new Karate("qsenPederasen", 30, maxHealth);
        participant3 = new Karate("durubura", 50, maxHealth);
        tournament = new Tournament("hacktues");
        tournament.addParticipant(participant1);
        tournament.addParticipant(participant2);
        tSize = tournament.getParticipants().size();
        group1 = new LinkedList<>();
        group2 = new LinkedList<>();

    }
    @Test
    void testAddParticipant()
    {
        tournament.addParticipant(participant3);
        tSize = tournament.getParticipants().size();

        assertEquals(tournament.getParticipants().get(tSize - 1), participant3);
        assertEquals(0, participant1.getId());
    }

    @Test
    void testSplitInGroups()
    {
        tournament.splitInGroups(group1, group2);

        assertEquals(participant1, group1.peek());
        assertEquals(participant2, group2.peek());
    }

    @Test
    void testFight()
    {
        Participant winner = tournament.fight(participant1, participant2);

        assertEquals(winner, participant2);
    }

    @Test
    void testGroupFight()
    {
        tournament.splitInGroups(group1, group2);
        tournament.groupFight(group1, group2);

        assertEquals(0, group1.size());
        assertEquals(group2.peek(), participant2);
        assertEquals(participant2.geHealth(), maxHealth);
    }
}
