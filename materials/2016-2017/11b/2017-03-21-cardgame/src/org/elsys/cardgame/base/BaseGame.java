package org.elsys.cardgame.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;
import org.elsys.cardgame.impl.DrawTopCard;

public abstract class BaseGame implements Game {

	private static final List<Operation> commonOperations =
			Arrays.asList(new DrawTopCard());

	private Deck deck;

	private Hand hand;

	private Map<String, Operation> operationsByName;

	protected BaseGame(Deck deck, List<Operation> gameSpecificOperations) {
		this.deck = deck;
		operationsByName = new HashMap<>();
		List<Operation> allOperations = new ArrayList<>(gameSpecificOperations);
		allOperations.addAll(commonOperations);
		for (Operation operation : allOperations) {
			operationsByName.put(operation.getName(), operation);
		}
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
