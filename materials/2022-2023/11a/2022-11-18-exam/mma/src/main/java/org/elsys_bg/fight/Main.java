package org.elsys_bg.fight;

import org.elsys_bg.fight.styles.Judo;
import org.elsys_bg.fight.styles.Karate;
import org.elsys_bg.fight.styles.MuaiThai;

public class Main {
    public static void main(String[] args) throws Exception {
        Tournament tournament = new Tournament("11a 2022");
        Participant p1 = new Karate("Ivan", 20, 400);
        Participant p2 = new MuaiThai("Pesho", 50, 200);
        Participant p3 = new Judo("Gosho", 90, 500);

        tournament.addParticipant(p1);
        tournament.addParticipant(p2);
        tournament.addParticipant(p3);

        tournament.start();
    }
}