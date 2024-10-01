package org.elsys.oop.heroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hero> party = new ArrayList<>();

        party.add(new Warrior(5, 4,2, "Knight"));

        Monster enemy = new Monster("Dragon", 5, 20, Arrays.asList(new String[]{"Darkness"}));

        System.out.println(party.get(0).getPower(party, enemy));
        System.out.println(enemy.getPower(party));
    }
}
