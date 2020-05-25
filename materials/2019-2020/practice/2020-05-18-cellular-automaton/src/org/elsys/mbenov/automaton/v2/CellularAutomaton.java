package org.elsys.mbenov.automaton.v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CellularAutomaton<T> {
    private AutomatonData<T> data;
    private Map<String, AutomatonRule<T>> rules = new HashMap<>();

    public void setData(AutomatonData<T> data) {
        this.data = data;
    }

    public void addRule(AutomatonRule<T> rule) {
        rules.put(rule.getLayout(), rule);
    }

    public void run(int generationCount, IAutomatonResult resultCollector) {
        System.out.println("Starting:");
        System.out.println(data.toString());

        IntStream.range(0, generationCount).forEach(i -> {
            List<T> buffer = data.stream()
                .map((area) -> {
                    String ruleKey = area.stream()
                            .map((v) -> v.toString())
                            .collect(Collectors.joining(""));
                    return rules.get(ruleKey).result;
                })
                .collect(Collectors.toList());

            data.updateValues(buffer);
        });

        resultCollector.collect(data);
    }
}
