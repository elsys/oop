package org.elsys.cardgame.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;

public abstract class BaseGame implements Game {

	private Deck deck;

	private Hand hand;

	private Map<String, Operation> operationsByName;

	protected BaseGame(List<Operation> operations) {
		operationsByName = new HashMap<>();
		for (Operation operation : operations) {
			operationsByName.put(operation.getName(), operation);
		}
		// TODO add common operations
	}
	
	@Override
	public void execute(String command) {
		// TODO handle parameters correctly - "twenty?:clubs"
		Operation operation = operationsByName.get(command);
		if (operation != null) {
			operation.execute(this);
		} else {
			throw new RuntimeException("ERROR: Unknown command.");
		}
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
	public Hand deal() {
		hand = deck.deal();
		return hand;
	}

	

}
