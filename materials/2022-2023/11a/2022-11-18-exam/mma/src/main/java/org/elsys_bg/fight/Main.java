package org.elsys_bg.fight;

import org.elsys_bg.fight.styles.Box;
import org.elsys_bg.fight.styles.Judo;
import org.elsys_bg.fight.styles.Karate;
import org.elsys_bg.fight.styles.MuaiThai;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Tournament tournament = new Tournament("11a 2022");
        Participant p1 = new Karate("Ivan", 20, 400);
        Participant p2 = new MuaiThai("Pesho", 50, 200);
        Participant p3 = new Judo("Gosho", 90, 500);
        */

        File f1 = new File("new 9.txt");
        TournamentReader tournamentReader = new TournamentReader(f1);
        Tournament tournament = new Tournament(" ");
        String heroName = "";
        String heroType;
        int power = 0;
        int health = 0;

        while(tournamentReader.hasNextHero())
        {
            String heroStats = tournamentReader.nextHero();
            String stats [] = heroStats.split(" ");

            heroType = stats[0];
            heroName = stats[1];
            power = Integer.parseInt(stats[2]);
            health = Integer.parseInt(stats[3]);

            switch (heroType.toLowerCase())
            {
                case "boxer" ->
                {
                    tournament.addParticipant(new Box(heroName, health, power));
                }
                case "judo" ->
                {
                    tournament.addParticipant(new Judo(heroName, health, power));
                }
                case "karate" ->
                {
                    tournament.addParticipant(new Karate(heroName, health, power));
                }
                default ->
                {
                    tournament.addParticipant(new MuaiThai(heroName, health, power));
                }

            }
        }

        tournament.start();
    }
}