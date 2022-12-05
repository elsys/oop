package org.elsys_bg.fight.styles;

import org.elsys_bg.fight.Participant;
import org.elsys_bg.fight.techniks.CanBox;
import org.elsys_bg.fight.techniks.CanWrestle;

public class Judo extends Participant implements CanWrestle, CanBox {
    public Judo(String name, int power, double health) {
        super(name, power, health);
    }

    @Override
    public void punch(Participant participant) {
        participant.takeDamage(power);
    }

    @Override
    public void toss(Participant participant) {
        participant.takeDamage(2 * power);
    }

    @Override
    public void attack(Participant participant) {
        punch(participant);
        toss(participant);
    }
}
