package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.List;

public class LengthRating extends Rating {
    public LengthRating(List<String> candidates) {
        super(candidates);
    }

    @Override
    public ArrayList<String> top(int n) {
        getDataSource().sort(new LengthComparator());
        return new ArrayList<>(getDataSource().subList(0, n));
    }
}
