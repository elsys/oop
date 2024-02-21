package org.elsys.oop;

public abstract class PlayerBase {
    private final String name;

    public PlayerBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int[] getMove(int[][] board);
}
