package org.elsys.mbenov.automaton.v2;

public class Main {
    public static void main(String[] args) {
        CellularAutomaton ca = new CellularAutomaton<Integer>();

        ca.setData(new AutomatonData<>(new Integer[]{1, 1, 0, 0}));
        // Rule 30
        ca.addRule(new AutomatonRule<>(new Integer[]{1, 1, 1}, 0));
        ca.addRule(new AutomatonRule<>(new Integer[]{1, 1, 0}, 0));
        ca.addRule(new AutomatonRule<>(new Integer[]{1, 0, 1}, 0));
        ca.addRule(new AutomatonRule<>(new Integer[]{1, 0, 0}, 1));
        ca.addRule(new AutomatonRule<>(new Integer[]{0, 1, 1}, 1));
        ca.addRule(new AutomatonRule<>(new Integer[]{0, 1, 0}, 1));
        ca.addRule(new AutomatonRule<>(new Integer[]{0, 0, 1}, 1));
        ca.addRule(new AutomatonRule<>(new Integer[]{0, 0, 0}, 0));

        long start = System.nanoTime();
        ca.run(100000, (res) -> {
            long end = System.nanoTime();
            System.out.println("Final result:");
            System.out.println(res);
            System.out.println("Time: " + (end - start)/1000000);
        });
    }
}
