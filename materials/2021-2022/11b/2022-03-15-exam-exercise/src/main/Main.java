package main;

import buildable.*;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("test");

        p1.addResource("wood", 700);
        p1.addResource("stone", 500);
        p1.addResource("gold", 500);
        p1.addResource("food", 500);

        try {
            p1.addBuildable(new BuildableFarm());
            p1.addBuildable(new BuildableQuarry());
            p1.addBuildable(new BuildableMine());
            p1.addBuildable(new BuildableMill());
            p1.addBuildable(new BuildableTower());
            p1.addBuildable(new BuildableCastle());
            p1.addBuildable(new BuildableMarket());
            p1.addBuildable(new BuildableLargeFarm());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=== Test buildings ===");
        String[] testBuildings = {
                "0001",
                "0006",
                "0007",
                "0002",
                "0003",
                "0004",
                "0007",
                "0008"
        };
        for (String id : testBuildings) {
            System.out.println("Try to build " + id);
            try {
                p1.build(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("=== Test updates ===");
        for (int i = 0; i < 20; i++) {
            System.out.println("Iteration #" + i);
            p1.update();
        }
    }
}
