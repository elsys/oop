package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.List;

public class BiasedRating extends Rating {
    private List<String> preferredCandidates;

    public BiasedRating(List<String> candidates, List<String> preferredCandidates) {
        super(candidates);
        this.preferredCandidates = preferredCandidates;
    }

    public List<String> getPreferredCandidates() {
        return preferredCandidates;
    }

    @Override
    public ArrayList<String> top(int n) {
        ArrayList<String> results = new ArrayList<>(getPreferredCandidates());
        ArrayList<String> dataSourceCopy = new ArrayList<>(getDataSource());
        dataSourceCopy.removeAll(getPreferredCandidates());
        results.addAll(dataSourceCopy);
        return new ArrayList<>(results.subList(0, n));
    }
}
