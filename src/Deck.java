import java.awt.MediaTracker;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	private String[] suit = { "Spades", "Hearts", "Diamonds", "Clubs" };
	private String[] title = { "Ace", "Duece", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	private int cardCounter = 0;
	
	public Deck() {
		int count = 1;
		for(int suitIndex=0; suitIndex < 4; suitIndex++) {
			for(int faceValue = 1; faceValue <= 13; faceValue++) {
				int value = faceValue;
				if(faceValue > 10)
					value = 10;
				ImageIcon imageIcon = new ImageIcon("image/card/" +
						count + ".png");
				int status = imageIcon.getImageLoadStatus();
				if(status != MediaTracker.COMPLETE) {
					System.out.println("Error loading ImageIcon");
					System.exit(0);
				}
				Card card = new Card(imageIcon, suit[suitIndex],
						title[faceValue - 1], value);
				deck.add(card);
				count++;
			}
		}
	}
	
	public Card drawCard() {
		if(cardCounter > 51) {
			System.out.println("Error - out of cards!");
			System.exit(0);
		}
		return deck.get(cardCounter++);
	}
}
