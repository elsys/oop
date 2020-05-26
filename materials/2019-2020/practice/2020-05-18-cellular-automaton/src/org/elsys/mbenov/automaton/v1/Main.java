package org.elsys.mbenov.automaton.v1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        CellularAutomaton ca = new CellularAutomaton();

        ca.setData(new Boolean[]{true, true, false, false});
        // Rule 30
        ca.setRules(new HashMap<String, Boolean>(){
            {
                put("111", false);
                put("110", false);
                put("101", false);
                put("100", true);
                put("011", true);
                put("010", true);
                put("001", true);
                put("000", false);
            }
        });

        long start = System.nanoTime();
        ca.run(100000, (res) -> {
            long end = System.nanoTime();
            System.out.println("Final result:");
            CellularAutomaton.printData(res);
            System.out.println("Time: " + (end - start)/1000000);
        });
    }
}
