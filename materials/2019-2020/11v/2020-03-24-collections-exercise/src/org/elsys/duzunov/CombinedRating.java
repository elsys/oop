package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.List;

public class CombinedRating extends Rating {
    private Rating r1;
    private Rating r2;

    public CombinedRating(List<String> candidates, Rating r1, Rating r2) {
        super(candidates);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void setDataSource(List<String> candidates) {
        super.setDataSource(candidates);
        getDataSource().sort(
                new PointsComparator(r1, r2, getDataSource().size())
        );
    }

    @Override
    public ArrayList<String> top(int n) {
        return new ArrayList<>(getDataSource().subList(0, n));
    }
}
