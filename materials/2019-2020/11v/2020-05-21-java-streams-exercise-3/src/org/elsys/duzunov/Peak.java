package org.elsys.duzunov;

import java.util.Objects;

public final class Peak {
    private static final int POSITION = 0;
    private static final int NAME = 1;
    private static final int HEIGHT = 2;
    private static final int PROMINENCE = 3;
    private static final int RANGE = 4;
    private static final int YEAR_OF_FIRST_ASCENT = 5;
    private static final int TOTAL_ASCENTS = 6;

    private final int position;
    private final String name;
    private final double height;
    private final double prominence;
    private final String range;
    private final int yearOfFirstAscent;
    private final int totalAscents;

    private Peak(int position,
                 String name,
                 double height,
                 double prominence,
                 String range,
                 int yearOfFirstAscent,
                 int totalAscents) {
        this.position = position;
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.range = range;
        this.yearOfFirstAscent = yearOfFirstAscent;
        this.totalAscents = totalAscents;
    }

    public static Peak createPeak(String line) {
        String[] tokens = line.split(",");

        int position = Integer.parseInt(tokens[POSITION]);
        String name = tokens[NAME];
        double height = Double.parseDouble(tokens[HEIGHT]);
        double prominence = Double.parseDouble(tokens[PROMINENCE]);
        String range = tokens[RANGE];
        int yearOfFirstAscent = Integer.parseInt(tokens[YEAR_OF_FIRST_ASCENT]);
        int totalAscents = Integer.parseInt(tokens[TOTAL_ASCENTS]);

        return new Peak(
                position,
                name,
                height,
                prominence,
                range,
                yearOfFirstAscent,
                totalAscents
        );
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getProminence() {
        return prominence;
    }

    public String getRange() {
        return range;
    }

    public int getYearOfFirstAscent() {
        return yearOfFirstAscent;
    }

    public int getTotalAscents() {
        return totalAscents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peak peak = (Peak) o;
        return getPosition() == peak.getPosition() &&
                getName().equals(peak.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getName());
    }
}
