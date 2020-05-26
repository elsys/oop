package org.elsys.mbenov.automaton.v3;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        runRule30();
        runGameOfLife();
    }

    private static void runRule30() {
        CellularAutomaton<Boolean> ca = new CellularAutomaton<>();

        ca.setData(new AutomatonData1D<>(new Boolean[]{true, true, false, false}){});
        ca.setRuleset(new IAutomatonRuleset<Boolean, Boolean>() {
            private Map<String, Boolean> ruleLookup = new HashMap<>() {
                {
                    put("000", false);
                    put("001", true);
                    put("010", true);
                    put("011", true);
                    put("100", true);
                    put("101", false);
                    put("110", false);
                    put("111", false);
                }
            };

            @Override
            public Boolean apply(List<Boolean> area) {
                String ruleKey = area.stream()
                        .map((cell) -> cell ? "1" : "0")
                        .collect(Collectors.joining(""));
                return ruleLookup.get(ruleKey);
            }
        });

        long start = System.nanoTime();
        ca.run(10, (res) -> {
            long end = System.nanoTime();
            System.out.println("Final result:");
            System.out.println(res);
            System.out.println("Time: " + (end - start)/1000000);
        }, true);
    }

    private static void runGameOfLife() {
        CellularAutomaton<Integer> ca = new CellularAutomaton<>();

//        // Random cells
//        Integer[][] startingData = {{
//            0, 0, 0, 0, 0, 0
//        }, {
//            0, 0, 1, 0, 0, 0
//        }, {
//            0, 0, 1, 1, 1, 0
//        }, {
//            0, 0, 1, 0, 0, 0
//        }, {
//            0, 0, 0, 0, 0, 0
//        }};

        // Oscilator
        Integer[][] startingData = {{
            0, 0, 0, 0, 0
        }, {
            0, 0, 1, 0, 0
        }, {
            0, 0, 1, 0, 0
        }, {
            0, 0, 1, 0, 0
        }, {
            0, 0, 0, 0, 0
        }};

        ca.setData(new AutomatonData2D<>(startingData));

        // Game of Life
        ca.setRuleset((IAutomatonRuleset<Integer, List<Integer>>) (List<List<Integer>> area) -> {
            int cell = area.get(1).get(1);
            long liveNeighbours = area.stream().flatMap(Collection::stream).filter((v) -> v == 1).count();
            if(area.get(1).get(1) == 1) liveNeighbours--;

            if(cell == 1) {
                // Any live cell with two or three live neighbours survives.
                return liveNeighbours >= 2 && liveNeighbours <= 3 ? 1 : 0;
            } else {
                // Any dead cell with three live neighbours becomes a live cell.
                return liveNeighbours == 3 ? 1 : 0;
            }
            // All other live cells die in the next generation. Similarly, all other dead cells stay dead.
        });

        long start = System.nanoTime();
        ca.run(100000, (res) -> {
            long end = System.nanoTime();
            System.out.println("Final result:");
            System.out.println(res);
            System.out.println("Time: " + (end - start)/1000000);
        }, true);
    }
}
