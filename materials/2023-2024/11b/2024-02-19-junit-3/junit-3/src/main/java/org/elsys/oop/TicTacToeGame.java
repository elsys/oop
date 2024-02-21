package org.elsys.oop;

import java.util.LinkedList;
import java.util.List;

public class TicTacToeGame {
    private int[][] board =  new int[3][3];

    private PlayerBase currentPlayer;

    public TicTacToeGame(PlayerBase p1, PlayerBase p2) {
        players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

        currentPlayer = p1;
    }

    private List<PlayerBase> players;

    private boolean hasFinished() {
        return false;
    }

    public void start() {
        while(!hasFinished()) {
            int[] playerMove = currentPlayer.getMove(board);
//            updateBoard(playerMove, currentPlayer);
//            renderer.renderBoard(board);

//            currentPlayer = nextPlayer;
        }
    }
}
