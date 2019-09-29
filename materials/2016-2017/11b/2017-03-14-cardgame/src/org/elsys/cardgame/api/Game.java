package org.elsys.cardgame.api;

import java.util.Arrays;
import java.util.List;

public interface Game {

	String getName();

	int getHandSize();

	Deck getDeck();

	Hand getDealtHand();

	Hand deal();

	void execute(String command);

	public static void play(String commands) {
		List<String> commandsList = Arrays.asList(commands.split("\\."));
		String gameCommand = commandsList.remove(0);
		Game game;
		if (gameCommand == "War") {
			game = new WarGame();
		}
		
	}
}
