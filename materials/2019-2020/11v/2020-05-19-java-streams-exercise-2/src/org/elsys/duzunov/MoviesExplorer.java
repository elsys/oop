package org.elsys.duzunov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MoviesExplorer {
    private final List<Movie> movies;

    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public MoviesExplorer(InputStream dataInput) {
        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(dataInput))
        ) {
            movies = reader.lines()
                    .map(Movie::createMovie)
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new IllegalArgumentException(
                    "Could not load dataset",
                    exception
            );
        }
    }

    /**
     * Returns all the movies loaded from the dataset.
     **/
    public Collection<Movie> getMovies() {
        return Collections.unmodifiableList(movies);
    }

    public long countMoviesReleasedInYear(int year) {
//        return movies.stream()
//                .filter(movie -> movie.getYear() == year)
//                .reduce(
//                        0,
//                        (count, movie) -> count + 1,
//                        Integer::sum
//                );

//        return movies.stream()
//                .filter(movie -> movie.getYear() == year)
//                .mapToLong(movie -> 1L)
//                .sum();

        return movies.stream()
                .filter(movie -> movie.getYear() == year)
                .count();
    }

    public Movie findFirstMovieWithTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().contains(title))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Collection<Actor> getAllActors() {
        return movies.stream()
                .flatMap(movie -> movie.getActors().stream())
                .collect(Collectors.toSet());
    }

    public int getFirstYear() {
//        return movies.stream()
//                .min(Comparator.comparingInt(Movie::getYear))
//                .get()
//                .getYear();

        return movies.stream()
                .map(Movie::getYear)
                .min(Comparator.comparingInt(year -> year))
                .get();
    }
}
