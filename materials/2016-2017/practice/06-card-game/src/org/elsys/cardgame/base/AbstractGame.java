package org.elsys.cardgame.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;
import org.elsys.cardgame.impl.Deal;

public abstract class AbstractGame implements Game {

	private static final List<Operation> commonOperations =
			Arrays.asList(new Deal());

	private Deck deck;

	private Hand hand;

	private Map<String, Operation> operations;

	protected AbstractGame(Deck deck, List<Operation> gameSpecificOperations) {
		this.deck = deck;
		this.operations = new HashMap<>();
		
		List<Operation> allOperations = new ArrayList<>(gameSpecificOperations);
		allOperations.addAll(commonOperations);

		for (Operation operation : allOperations) {
			this.operations.put(operation.getName(), operation);
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
	public void setDealtHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public void process(String command) {
		Operation operation = operations.get(command);
		if (operation != null) {
			operation.execute(this);
		} else {
			throw new CardException("ERROR: Unknown command.");
		}
	}

}
