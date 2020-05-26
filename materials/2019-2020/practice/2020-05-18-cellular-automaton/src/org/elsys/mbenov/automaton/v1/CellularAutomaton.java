package org.elsys.mbenov.automaton.v1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CellularAutomaton {
    private Boolean[] data;
    private Map<String, Boolean> rules;

    public void setData(Boolean[] data) {
        this.data = data;
    }

    public void setRules(Map<String, Boolean> rules) {
        this.rules = rules;
    }

    private Boolean[] getArea(int index) {
        Boolean[] area = new Boolean[3];

        // Current item
        area[1] = data[index];

        // Left neighbour
        area[0] = index > 0 ? data[index - 1] : data[data.length - 1];

        // Right neighbour
        area[2] = index < data.length - 1 ? data[index + 1] : data[0];

        // Same as above but without the ternary operator
//        // Left neighbour
//        if(index > 0) {
//            area[0] = data[index - 1];
//        } else {
//            area[0] = data[data.length - 1];
//        }

//        // Right neighbour
//        if(index < data.length - 1) {
//            area[2] = data[index+1];
//        } else {
//            area[2] = data[0];
//        }

        return area;
    }

    public void run(int generationCount, IAutomatonResult o) {
        System.out.println("Starting:");
        CellularAutomaton.printData(data);

        IntStream.range(0, generationCount).forEach(i -> {
            List<Boolean> buffer = IntStream.range(0, data.length)
                    .mapToObj((index) -> {
                        Boolean[] area = getArea(index);
                        String ruleKey = Arrays.stream(area)
                                .map((v) -> v ? "1" : "0")
                                .collect(Collectors.joining(""));

                        return rules.get(ruleKey);
                    })
                    .collect(Collectors.toList());
            buffer.toArray(data);
        });

        o.collect(data);
    }

    public static void printData(Boolean[] data) {
        System.out.println(Arrays.stream(data)
                .map(v -> v ? "1" : "0")
                .collect(Collectors.joining(" ", "(", ")"))
        );
    }
}
