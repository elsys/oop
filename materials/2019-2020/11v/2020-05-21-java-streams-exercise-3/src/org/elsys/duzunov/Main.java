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
        } catch (IOException exception) {
            System.out.println("Could not load peaks dataset.");
        }
    }
}
