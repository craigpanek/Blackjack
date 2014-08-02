/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage bi = null;
    private final TexturePaint texture;

    private BlackjackGame game;

    public ImagePanel(BlackjackGame game) {
        this.game = game;
        setOpaque(false);
        try {
    	    InputStream input = getClass().getResourceAsStream("image/"
    	    		+ "table/poker-surface-2.png");
            bi = ImageIO.read(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        texture = new TexturePaint
                (bi, new Rectangle(bi.getWidth(), bi.getHeight()));
    }

    private void paintHand(CardHand hand, int yVal, Graphics g) {
        ArrayList<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            g.drawImage(cards.get(i).getImage(), (75 + (30 * i)), yVal, this);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
    	g2.setPaint(texture);
    	g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); // what is the purpose of this line?
        						 // and why doesn't it erase the green paint?

        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
        g.setColor(Color.BLACK);
        g.drawString(game.getMessage1(), 170, 185);

        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        g.setColor(Color.BLUE);
        g.drawString(game.getMessage2(), 180, 355);

        if (game.getDealerHand() != null) {
            paintHand(game.getDealerHand(), 25, g);
            paintHand(game.getPlayerHand(), 190, g);
        }
    }
}
