package org.elsys.duzunov;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream videosInputStream = Files.newInputStream(
                    Path.of("vgsales.csv")
            );
            var explorer = new VideoGamesExplorer(videosInputStream);

            System.out.println(explorer.findNameOfLeastSoldVideoGameInJapan());
            System.out.println(
                    explorer.findNameOfVideoGameWithLargestSaleDifference()
            );
            System.out.println(
                    explorer.findNamesOfTopNVideoGamesBySalesInEurope(10)
            );

            System.out.println(
                    explorer.findAverageSoldCopiesByPublisher("Nintendo")
            );
            System.out.println(
                    explorer.findAverageSoldCopiesByPublisher("Lidl")
            );

            System.out.println(
                    explorer.findRankOfMostSoldVideoGameByPlatformAndGenre(
                            "PS4",
                            "Sports"
                    )
            );

            System.out.println(
                    explorer.findPublisherWithMostVideoGamesInYear(1994)
            );
        } catch (IOException exception) {
            System.out.println("Could not load video games dataset.");
        }
    }
}
