/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

import java.util.ArrayList;

public class CardHand {

	private ArrayList<Card> hand = new ArrayList<Card>();

	public CardHand() {

	}

	public void turnCardsFaceUp() {
		for (int i = 0; i < hand.size(); i++) {
			hand.get(i).setFaceUp();
		}
	}

	public int getHardHand() {
		int cardTotal = 0;
		for (int i = 0; i < hand.size(); i++) {
			cardTotal += hand.get(i).getValue();
		}
		return cardTotal;
	}

	public int getSoftHand() {
		int cardTotal = getHardHand();
		if (cardTotal < 12 && haveAnAce())
			cardTotal += 10;
		return cardTotal;

	}

	public void addCard(Card card) {
		hand.add(card);
	}

	boolean isBlackjack() {
		return ((hand.get(0).isAce() && hand.get(1).isFaceCard()) || (hand
				.get(0)).isFaceCard() && hand.get(1).isAce());
	}

	public boolean isBust() {
		return getSoftHand() > 21;
	}

	public boolean haveAnAce() {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).isAce())
				return true;
		}
		return false;
	}

	public ArrayList<Card> getCards() {
		return hand;
	}
}
