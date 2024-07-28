package org.elsys.oop.heroes;

import java.util.List;

public class Warrior extends Hero {
    public Warrior(int level, int strength, int intelligence, String specialty) {
        super(level, strength, intelligence, specialty);
    }

    @Override
    public int getPower(List<Hero> party, Monster monster) {
        int pow = getLevel() * getStrength();

        if(getSpecialty() == "Knight") {
            for (Hero h : party) {
                if (h.getSpecialty() == "Cleric") {
                    pow *= 1.25;
                }
            }
        }

        return pow;
    }
}
