package org.elsys.duzunov;

public class Peak {
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
        throw new UnsupportedOperationException();
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
}
