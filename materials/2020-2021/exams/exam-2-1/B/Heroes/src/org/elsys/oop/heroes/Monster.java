package org.elsys.oop.heroes;

import java.util.List;

public class Monster {
    private String name;
    private int level;
    private int strength;
    private List<String> traits;

    public Monster(String name, int level, int strength, List<String> traits) {
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.traits = traits;
    }

    public String getName() {
        return name;
    }

    public List<String> getTraits() {
        return traits;
    }

    private boolean isOpposite(String a, String b) {
        if(a == "Evil" && b == "Knight") return true;
        return false;
    }

    public int getPower(List<Hero> party) {
        int pow = level * strength;

        for (Hero hero : party) {
            for (String trait : traits) {
                if (isOpposite(trait, hero.getSpecialty())) {
                    pow *= 1.25;
                }
            }
        }

        return pow;
    }
}
