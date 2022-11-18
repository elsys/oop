package org.elsys_bg.fight.styles;

import org.elsys_bg.fight.Participant;
import org.elsys_bg.fight.techniks.CanBox;
import org.elsys_bg.fight.techniks.CanKick;
import org.elsys_bg.fight.techniks.CanSpin;

public class MuaiThai extends Participant implements CanBox, CanKick, CanSpin {
    public MuaiThai(String name, int power, double health) {
        super(name, power, health);
    }

    @Override
    public void punch(Participant participant) {
        participant.takeDamage(spin(power));
    }

    @Override
    public void kick(Participant participant) {
        participant.takeDamage(spin(1.5 * power));
    }

    @Override
    public double spin(double damage) {
        return damage * 2;
    }

    @Override
    public void attack(Participant participant) {
        punch(participant);
        kick(participant);
    }
}
