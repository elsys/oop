package org.elsys.mbenov.automaton.v3;

import java.util.List;

public interface IAutomatonRuleset<T, N> {
    T apply(List<N> area);
}
