package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.List;

public abstract class Rating {
    private ArrayList<String> dataSource;

    public Rating(List<String> candidates) {
        setDataSource(candidates);
    }

    public void setDataSource(List<String> candidates) {
        dataSource = new ArrayList<>(candidates);
    }

    public ArrayList<String> getDataSource() {
        return dataSource;
    }

    public abstract ArrayList<String> top(int n);
}
