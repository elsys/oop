package org.elsys.oop.heroes;

import java.util.List;

public class Wizard extends Hero {
    public Wizard(int level, int strength, int intelligence, String specialty) {
        super(level, strength, intelligence, specialty);
    }

    private boolean isOpposite(String a, String b) {
        return true;
    }

    @Override
    public int getPower(List<Hero> party, Monster monster) {
        int pow = getLevel() * getIntelligence();

        for(String trait : monster.getTraits()) {
            if(isOpposite(trait, getSpecialty())) {
                pow *= 1.25;
            }
        }

        return pow;
    }
}
