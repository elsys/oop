package org.elsys.cardgame.api;

public interface Operation {

	String getName();

	void execute(Game game, String... params);

}
