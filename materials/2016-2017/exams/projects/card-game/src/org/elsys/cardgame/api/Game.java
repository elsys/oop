package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.elsys.cardgame.impl.WarGame;

public interface Game {

	Deck getDeck();

	Hand getDealtHand();

	void setDealtHand(Hand hand);

	void process(String commands);

	public static void play(String commands) {
		List<String> commandsList = new ArrayList<>(
				Arrays.asList(commands.split("\\.")));
		
		String gameCommand = commandsList.remove(0);
		Game game;
		if (gameCommand.equals("War")) {
			game = new WarGame();
		} else {
			throw new RuntimeException("ERROR: Unknown command.");
		}

		for (String command : commandsList) {
			game.process(command);
		}
	}
}
