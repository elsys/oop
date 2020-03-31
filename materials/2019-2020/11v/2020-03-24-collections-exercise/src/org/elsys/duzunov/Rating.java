package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.List;

public abstract class Rating {
    private List<String> dataSource;

    public Rating(List<String> candidates) {
        setDataSource(candidates);
    }

    public void setDataSource(List<String> candidates) {
        dataSource = candidates;
    }

    public List<String> getDataSource() {
        return dataSource;
    }

    public abstract ArrayList<String> top(int n);
}
