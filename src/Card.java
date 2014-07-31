/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {

	public static final String[] suits = { "Spades", "Hearts", "Diamonds",
			"Clubs" };
	public static final String[] titles = { "Ace", "Duece", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
			"King" };
	private ImageIcon faceImageIcon;
	private ImageIcon backImageIcon;
	private String suit;
	private String title;
	private int value;
	private boolean isFaceUp = true;

	public Card(ImageIcon faceImageIcon, ImageIcon backImageIcon, String suit,
			String title, int value) {
		this.faceImageIcon = faceImageIcon;
		this.backImageIcon = backImageIcon;
		this.suit = suit;
		this.title = title;
		this.value = value;
	}

	public ImageIcon getImageIcon() {
		if (isFaceUp)
			return faceImageIcon;
		else
			return backImageIcon;
	}

	public Image getImage() {
		return getImageIcon().getImage();
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

	public boolean isFaceUp() {
		return isFaceUp;
	}

	public Card setFaceUp() {
		this.isFaceUp = true;
		return this;
	}

	public Card setFaceDown() {
		this.isFaceUp = false;
		return this;
	}

	public boolean isFaceCard() {
		return this.value == 10;
	}

	public boolean isAce() {
		return this.value == 1;
	}
}
