package org.elsys.oop.heroes;

import java.util.List;

public abstract class Hero {
    private int level;
    private int strength;
    private int intelligence;
    private String specialty;

    public Hero(int level, int strength, int intelligence, String specialty) {
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.specialty = specialty;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getSpecialty() {
        return specialty;
    }

    public abstract int getPower(List<Hero> party, Monster monster);
}
