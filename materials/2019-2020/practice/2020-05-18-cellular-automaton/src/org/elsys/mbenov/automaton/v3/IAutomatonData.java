package org.elsys.mbenov.automaton.v3;

import java.util.List;
import java.util.stream.Stream;

public interface IAutomatonData<T> {
    List<T> getArea(int index);
    Stream<List> stream();
    void updateValues(List buffer);
}
