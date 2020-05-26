package org.elsys.mbenov.automaton.v3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CellularAutomaton<T> {
    public IAutomatonData<T> data;
    public IAutomatonRuleset<T, T> ruleset;

    public void setData(IAutomatonData<T> data) {
        this.data = data;
    }

    public void setRuleset(IAutomatonRuleset rules) {
        this.ruleset = rules;
    }

    public void run(int generationCount, IAutomatonResult resultCollector) {
        run(generationCount, resultCollector, false);
    }

    public void run(int generationCount, IAutomatonResult resultCollector, boolean printAfterCycle) {
        System.out.println("Starting:");
        System.out.println(data.toString());

        IntStream.range(0, generationCount).forEach(i -> {
            List buffer = data.stream()
                .map(area -> ruleset.apply(area))
                .collect(Collectors.toList());

            data.updateValues(buffer);

            if(printAfterCycle) {
                System.out.println("After generation " + i);
                System.out.println(data);
            }
        });

        resultCollector.collect(data);
    }
}
