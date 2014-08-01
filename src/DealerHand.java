/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

public class DealerHand extends CardHand {
	public void showDealerDownCard() {
		super.getCards().get(1).setFaceUp();
	}
}
