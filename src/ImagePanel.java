import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private Deck deck = new Deck();
	
	public ImagePanel() {
		
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = deck.drawCard();
				Image image = card.getImage();
				g.drawImage(image,  10 + (j * 35),  i * 35, this);
			}
		}
	}
	
	
}
