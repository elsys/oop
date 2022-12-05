package org.elsys_bg.fight;

import org.elsys_bg.fight.styles.Karate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    Participant participant;
    final int MAX_HEALTH = 100;

    @BeforeEach
    void setUp()
    {
        participant = new Karate("terminator", 10, MAX_HEALTH);
    }

    @Test
    void testTakeDamage()
    {
        participant.takeDamage(20);
        assertEquals(MAX_HEALTH - 20, participant.geHealth());
    }

    @Test
    void testIsKnockedOutTrue()
    {
        participant.takeDamage(MAX_HEALTH);
        assertTrue(participant.isKnockedOut());
    }

    @Test
    void testResetHealth()
    {
        participant.takeDamage(participant.geHealth());
        participant.resetHealth();
        assertEquals(MAX_HEALTH, participant.geHealth());
    }

    @Test
    void testIsKnockedOutFalse()
    {
        assertFalse(participant.isKnockedOut());
    }
}


