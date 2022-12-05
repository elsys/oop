package org.elsys_bg.fight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TournamentReader {
    String [] heroes;
    private int size;
    private int counter;

    TournamentReader(File file)
    {
        Scanner input;
        heroes = new String[2];
        size = 0;
        counter = 0;

        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(input.hasNextLine())
        {
            String heroStats = input.nextLine();
            heroStats.trim();
            String [] stats = heroStats.split(" ");
            String heroType = stats[0].toLowerCase();

            if(4 == stats.length)
            {
                if(heroType.equals("boxer") || heroType.equals("karate") || heroType.equals("judo") || heroType.equals("kung_fu"))
                {
                    try
                    {
                        Integer.parseInt(stats[2]);
                        Integer.parseInt(stats[3]);
                    }
                    catch (Exception exception)
                    {
                        stats[2] = "0";
                    }

                    if(stats[2] != "0")
                    {
                        heroes[size++] = heroStats;
                    }

                }
            }


        }
    }

    public String nextHero()
    {
        return heroes[counter++];
    }

    public boolean hasNextHero()
    {
        return counter == size;
    }
}
