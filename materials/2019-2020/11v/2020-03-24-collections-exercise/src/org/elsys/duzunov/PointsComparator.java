package org.elsys.duzunov;

import java.util.Comparator;

public class PointsComparator implements Comparator<String> {
    private Rating r1;
    private Rating r2;
    private int candidatesCount;

    public PointsComparator(Rating r1, Rating r2, int candidatesCount) {
        this.r1 = r1;
        this.r2 = r2;
        this.candidatesCount = candidatesCount;
    }

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(points(o1), points(o2));
    }

    private int points(String string) {
        return pointsBy(r1, string) + pointsBy(r2, string);
    }

    private int pointsBy(Rating rating, String string) {
        var topCandidates = rating.top(candidatesCount);
        return topCandidates.indexOf(string);
    }
}
