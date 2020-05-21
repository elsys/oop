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
            System.out.println(explorer.getFirstYear());

            Actor bruceWillis = new Actor("Bruce", "Willis");
            System.out.println(explorer.getAllMoviesByActor(bruceWillis));

            System.out.println(explorer.getMoviesSortedByReleaseYear());
            System.out.println(
                    explorer.findYearWithLeastNumberOfReleasedMovies()
            );
            System.out.println(explorer.findMovieWithGreatestNumberOfActors());
        } catch (IOException exception) {
            System.out.println("Could not load videos dataset.");
        }
    }
}
