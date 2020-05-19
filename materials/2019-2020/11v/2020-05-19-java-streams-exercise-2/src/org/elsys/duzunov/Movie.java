package org.elsys.duzunov;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Movie {
    private final String title;
    private final int year;
    private final HashSet<Actor> actors = new HashSet<>();

    private Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public static Movie createMovie(String line) {
        String[] tokens = line.split("/");
        String title = parseMovieTitle(tokens[0]);
        String releaseYear = parseMovieYear(tokens[0]);

        Movie movie = new Movie(title, Integer.parseInt(releaseYear));
        movie.addAllActors(parseActors(tokens));

        return movie;
    }

    private static String parseMovieTitle(String token) {
        return token.substring(0, token.lastIndexOf("(")).strip();
    }

    private static String parseMovieYear(String token) {
        String year =
                token.substring(
                        token.lastIndexOf("(") + 1,
                        token.lastIndexOf(")")
                );

        if (year.contains(",")) {
            year = year.substring(0, year.indexOf(","));
        }

        return year;
    }

    private static HashSet<Actor> parseActors(String[] tokens) {
        HashSet<Actor> actors = new HashSet<>();

        for (int i = 1; i < tokens.length; i++) {
            String[] name = tokens[i].split(", ");
            String firstName = name[0].strip();
            String lastName = "";

            if (name.length > 1) {
                firstName = name[1].strip();
                lastName = name[0].strip();
            }

            actors.add(new Actor(firstName, lastName));
        }

        return actors;
    }

    private void addAllActors(Collection<Actor> actors) {
        this.actors.addAll(actors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Set<Actor> getActors() {
        return Collections.unmodifiableSet(actors);
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", year=" + year + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getYear() == movie.getYear() &&
                getTitle().equals(movie.getTitle()) &&
                getActors().equals(movie.getActors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getYear(), getActors());
    }
}
