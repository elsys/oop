package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.elsys.cardgame.impl.WarGame;

public interface Game {

	String getName();

	int getHandSize();

	Deck getDeck();

	Hand getDealtHand();

	Hand deal();

	void execute(String command);

	public static void play(String commands) {
//		List<String> commandsList = new ArrayList<>(
//				Arrays.asList(commands.split("\\.")));
		List<String> commandsList = Arrays.asList(commands.split("\\."));

		String gameCommand = commandsList.get(0);
		Game game;
		if (gameCommand.equals("War")) {
			game = new WarGame();
		} else {
			throw new RuntimeException("ERROR: Unknown command.");
		}
		for (String command : commandsList.subList(1, commandsList.size())) {
			game.execute(command);
		}
		
	}
}
