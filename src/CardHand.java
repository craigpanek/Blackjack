import java.util.ArrayList;

public class CardHand {

	private ArrayList<Card> hand = new ArrayList<Card>();

	public CardHand() {

	}

	public int getHardHand() {
		return -1;
	}

	public int getSoftHand() {
		return -1;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	boolean handIsBlackjack() {
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
