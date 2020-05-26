package org.elsys.duzunov;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream peaksInputStream = Files.newInputStream(
                    Path.of("mountains.txt")
            );
            var peakStats = new PeakStats(peaksInputStream);

            System.out.println(peakStats.shortestNotAscended());
            System.out.println(peakStats.averageAscentsInTopN(10));
            System.out.println(peakStats.getPositionByProminence(8091));
            System.out.println(peakStats.getHighestAscentByYear(1994));
            System.out.println(peakStats.getNonHimalayaNamesByProminence());
            System.out.println(
                    peakStats.getRangeWithGreatestNumberOfPeaks(10)
            );
        } catch (IOException exception) {
            System.out.println("Could not load peaks dataset.");
        }
    }
}
