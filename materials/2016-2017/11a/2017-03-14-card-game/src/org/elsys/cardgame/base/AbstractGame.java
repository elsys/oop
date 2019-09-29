package org.elsys.cardgame.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;

public abstract class AbstractGame implements Game {

	private Deck deck;

	private Hand hand;

	private Map<String, Operation> operations;

	protected AbstractGame(List<Operation> operations) {
		this.operations = new HashMap<>();
		for (Operation operation : operations) {
			this.operations.put(operation.getName(), operation);
		}
		// TODO add all common operations
	}

	@Override
	public Deck getDeck() {
		return deck;
	}

	@Override
	public Hand getDealtHand() {
		return hand;
	}

	@Override
	public void setDealtHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public void process(String commands) {
		String[] commandArray = commands.split("\\.");
		for (String command : commandArray) {
			// TODO handle params
			Operation operation = operations.get(command);
			if (operation != null) {
				operation.execute(this);
			}
		}
	}

}
