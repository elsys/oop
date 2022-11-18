package org.elsys_bg.fight.styles;

import org.elsys_bg.fight.Participant;
import org.elsys_bg.fight.techniks.CanBox;

public class Box extends Participant implements CanBox {
    public Box(String name, int power, double health) {
        super(name, power, health);
    }

    @Override
    public void punch(Participant participant) {
        participant.takeDamage(power);
    }

    @Override
    public void attack(Participant participant) {
        punch(participant);
    }
}
