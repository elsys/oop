package org.elsys.oop;

import java.util.Scanner;

public class ConsolePlayer extends PlayerBase {
    private final Scanner sc;

    public ConsolePlayer(String name) {
        super(name);

        sc = new Scanner(System.in);
    }

    @Override
    public int[] getMove(int[][] board) {
        int x = sc.nextInt();
        int y = sc.nextInt();

//        TODO: Validate coords
//        TODO: Loop input until coords are valid

        return new int[]{x, y};
    }
}
