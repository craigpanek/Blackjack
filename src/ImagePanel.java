import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private Deck deck = new Deck();
	
	public ImagePanel() {
		deck.shuffleDeck();
	}

	private void drawHand(CardHand hand, int xVal, Graphics g) {
		ArrayList<Card> cards = hand.getCards();
		for(int i=0; i < cards.size(); i++) {
			g.drawImage(cards.get(i).getImage(), (75 + (30 * i)), xVal, this);
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		CardHand dealerHand = new CardHand();
		CardHand playerHand = new CardHand();
		dealerHand.addCard(deck.drawCard());
		dealerHand.addCard(deck.drawCard().setFaceDown());
		playerHand.addCard(deck.drawCard());
		playerHand.addCard(deck.drawCard());
		
		drawHand(dealerHand, 35, g);
		drawHand(playerHand, 200, g);
		
//		Image image1 = deck.drawCard().getImage();
//		Image image2 = deck.drawCard().setFaceDown().getImage();
//		Image image3 = deck.drawCard().getImage();
//		Image image4 = deck.drawCard().getImage();
//		
//		g.drawImage(image1,  75,  35,  this);
//		g.drawImage(image2,  105,  35,  this);
//		g.drawImage(image3,  75,  200,  this);
//		g.drawImage(image4,  105,  200,  this);

//		deck = new Deck();
//		for(int i = 1; i <= 4; i++) {
//			for (int j = 1; j <= 13; j++) {
//				Card card = deck.drawCard();
//				Image image = card.getImage();
//				g.drawImage(image,  10 + (j * 35),  i * 35, this);
//			}
//		}
	}
}
