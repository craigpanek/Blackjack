/**
 * Copyright 2014 Craig Panek, Peter "Felix" Nguyen
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BlackjackFrame extends JFrame {

	private JButton jbtnPlus1 = new JButton("+1");
	private JButton jbtnPlus5 = new JButton("+5");
	private JButton jbtnClear = new JButton("Clear");
	private JLabel jlblBalance = new JLabel(" Balance:");
	private JLabel jlblBet = new JLabel("  Bet:");
	private JButton jbtnDeal = new JButton("Deal");
	private JButton jbtnHit = new JButton("Hit");
	private JButton jbtnStand = new JButton("Stand");
	private JButton jbtnDouble = new JButton("Double");
	private JButton jbtnSplit = new JButton("Split");
	private JButton jbtnRebet = new JButton("Rebet");
	private JButton jbtnReset = new JButton("Reset");
	private BlackjackGame game = new BlackjackGame();
	private ImagePanel imagePanel = new ImagePanel(game);

	public BlackjackFrame() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel lowerLeftPanel = new JPanel(new GridLayout(2, 1));
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p1 = new JPanel();
		p1.add(jbtnPlus1);
		p1.add(jbtnPlus5);
		p1.add(jbtnClear);
		JPanel p2 = new JPanel(new GridLayout(1, 2));
		p2.add(jlblBalance);
		p2.add(jlblBet);
		lowerLeftPanel.add(p1);
		lowerLeftPanel.add(p2);
		lowerLeftPanel.setBorder(new LineBorder(Color.BLACK, 1));
		JPanel lowerRightPanel = new JPanel(new GridLayout(2, 1));
		JPanel p3 = new JPanel();
		p3.add(jbtnDeal);
		p3.add(jbtnHit);
		p3.add(jbtnStand);
		p3.add(jbtnDouble);
		p3.add(jbtnSplit);
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4.add(jbtnRebet);
		p4.add(jbtnReset);
		lowerRightPanel.add(p3);
		lowerRightPanel.add(p4);
		lowerRightPanel.setBorder(new LineBorder(Color.BLACK, 1));
		lowerPanel.add(lowerLeftPanel);
		lowerPanel.add(lowerRightPanel);
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		mainPanel.add(imagePanel, BorderLayout.CENTER);
		imagePanel.setPreferredSize(new Dimension(300, 300));
		showBalanceAndBet();
		add(mainPanel);
		jbtnDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.dealCards();
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.playerHit();
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.reset();
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.playerStand();
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnPlus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setBet(game.getBet() + 1);
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnPlus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setBet(game.getBet() + 5);
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.clearBet();
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnRebet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setBet(game.getPreviousBet());
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
		jbtnDouble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.doubleDown();
				imagePanel.repaint();
				showBalanceAndBet();
			}
		});
	}

	private void showBalanceAndBet() {
		jlblBalance.setText(" Balance: " + game.getBalance());
		jlblBet.setText("  Bet: " + game.getBet());
	}
}
