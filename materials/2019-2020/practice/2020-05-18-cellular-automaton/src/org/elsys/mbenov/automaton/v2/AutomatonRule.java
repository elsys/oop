package org.elsys.mbenov.automaton.v2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AutomatonRule<T> {
    T[] prerequisites;
    T result;

    public AutomatonRule(T[] prerequisites, T result) {
        this.prerequisites = prerequisites;
        this.result = result;
    }

    public String getLayout() {
        return Arrays.stream(prerequisites)
                .map((v) -> v.toString())
                .collect(Collectors.joining(""));
    }
}
