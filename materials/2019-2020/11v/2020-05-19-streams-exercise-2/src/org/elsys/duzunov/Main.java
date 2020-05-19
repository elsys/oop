package org.elsys.duzunov;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream moviesInputStream = Files.newInputStream(
                    Path.of("movies-mpaa.txt")
            );
            var explorer = new MoviesExplorer(moviesInputStream);

            System.out.println(explorer.countMoviesReleasedInYear(2003));
            System.out.println(explorer.findFirstMovieWithTitle("car"));
            System.out.println(explorer.getAllActors());
        } catch (IOException exception) {
            System.out.println("Could not load videos dataset.");
        }
    }
}
