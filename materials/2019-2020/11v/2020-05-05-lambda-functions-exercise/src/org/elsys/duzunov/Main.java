package org.elsys.duzunov;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream videosInputStream = Files.newInputStream(
                    Path.of("USvideos.txt")
            );
            var explorer = new YouTubeTrendsExplorer(videosInputStream);

            System.out.println(explorer.findIdOfLeastLikedVideo());
            System.out.println(explorer.findIdOfMostLikedLeastDislikedVideo());
            System.out.println(explorer.findDistinctTitlesOfTop3VideosByViews());
//            System.out.println(explorer.findIdOfMostTaggedVideo());
//            System.out.println(explorer.findTitleOfFirstVideoTrendingBefore100KViews());
//            System.out.println(explorer.findIdOfMostTrendingVideo());
        } catch (IOException exception) {
            System.out.println("Could not load videos dataset.");
        }
    }
}
