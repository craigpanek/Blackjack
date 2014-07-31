/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private BlackjackGame game;

	public ImagePanel(BlackjackGame game) {
		this.game = game;
	}

	private void paintHand(CardHand hand, int yVal, Graphics g) {
		ArrayList<Card> cards = hand.getCards();
		for (int i = 0; i < cards.size(); i++) {
			g.drawImage(cards.get(i).getImage(), (75 + (30 * i)), yVal, this);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
		g.setColor(Color.BLACK);
		g.drawString(game.getMessage1(), 170, 185);

		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		g.setColor(Color.RED);
		g.drawString(game.getMessage2(), 200, 355);

		if (game.getDealerHand() != null) {
			paintHand(game.getDealerHand(), 25, g);
			paintHand(game.getPlayerHand(), 190, g);
		}
	}
}
