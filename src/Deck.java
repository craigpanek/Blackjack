/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

import java.awt.MediaTracker;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int cardCounter = 0;
	private final int CARD_WARNING_INDEX = 40;

	public Deck() {
		int count = 1;
		ImageIcon backImageIcon = new ImageIcon("image/card/b1fv.png");
		verifyImageIconLoad(backImageIcon);

		for (int suitIndex = 0; suitIndex < 4; suitIndex++) {
			for (int faceValue = 1; faceValue <= 13; faceValue++) {
				int value = faceValue;
				if (faceValue > 10)
					value = 10;
				ImageIcon faceImageIcon = new ImageIcon("image/card/" + count
						+ ".png");
				verifyImageIconLoad(faceImageIcon);
				Card card = new Card(faceImageIcon, backImageIcon,
						Card.suits[suitIndex], Card.titles[faceValue - 1],
						value);
				deck.add(card);
				count++;
			}
		}
	}

	public void verifyImageIconLoad(ImageIcon imageIcon) {
		if (imageIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
			System.out.println("Error loading ImageIcon");
			System.exit(0);
		}
		return;
	}

	public Card drawCard() {
		if (cardCounter > 51) {
			System.out.println("Program error - out of cards!");
			System.exit(0);
		}
		return deck.get(cardCounter++);
	}

	public boolean isEnoughCardsInDeck() {
		return cardCounter <= CARD_WARNING_INDEX;
	}

	public void shuffleDeck() {
		cardCounter = 0;
		for (int i = 0; i < 52; i++) {
			int index = (int) (Math.random() * 52);
			Card temp = deck.get(i);
			deck.set(i, deck.get(index));
			deck.set(index, temp);
		}
		for(int i=0; i < 52; i++) {
			deck.get(i).setFaceUp();
		}
	}
}
