package org.elsys_bg.fight.styles;

import org.elsys_bg.fight.Participant;
import org.elsys_bg.fight.techniks.CanBox;
import org.elsys_bg.fight.techniks.CanKick;

public class Karate extends Participant implements CanBox, CanKick {
    public Karate(String name, int power, double health) {
        super(name, power, health);
    }

    @Override
    public void punch(Participant participant) {
        participant.takeDamage(power);
    }

    @Override
    public void kick(Participant participant) {
        participant.takeDamage(1.5 * power);
    }

    @Override
    public void attack(Participant participant) {
        punch(participant);
        kick(participant);
    }
}
