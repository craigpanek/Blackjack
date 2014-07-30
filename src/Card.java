import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {
	
	private ImageIcon imageIcon;
	private int value;
	private String suit;
	private String title;
	
	public Card(ImageIcon imageIcon, String suit, String title, int value) {
		if(imageIcon == null)
			System.out.println("Error");
		this.imageIcon = imageIcon;
		this.suit = suit;
		this.title = title;
		this.value = value;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public Image getImage() {
		return imageIcon.getImage();
	}
	
	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public String getTitle() {
		return title;
	}
}
