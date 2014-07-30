import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BlackjackFrame extends JFrame {

	private int balance = 100;
	JPanel imagePanel = new ImagePanel();
	JButton jbtnPlus1;
	JButton jbtnPlus5;
	JButton jbtnClear;
	JLabel jlblBalance;
	JButton jbtnDeal;
	JButton jbtnHit;
	JButton jbtnStand;
	JButton jbtnDouble;
	JButton jbtnSplit;
	
	public BlackjackFrame() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel lowerLeftPanel = new JPanel(new GridLayout(2, 1));
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jbtnPlus1 = new JButton("+1");
		jbtnPlus5 = new JButton("+5");
		jbtnClear = new JButton("Clear");
		JPanel p1 = new JPanel();
		p1.add(jbtnPlus1);
		p1.add(jbtnPlus5);
		p1.add(jbtnClear);
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jlblBalance = new JLabel("Balance: " + balance);
		p2.add(jlblBalance);
		lowerLeftPanel.add(p1);
		lowerLeftPanel.add(p2);
		lowerLeftPanel.setBorder(new LineBorder(Color.BLACK, 1));
		JPanel lowerRightPanel = new JPanel(new GridLayout(2, 1));
		jbtnDeal = new JButton("Deal");
		jbtnHit = new JButton("Hit");
		jbtnStand = new JButton("Stand");
		jbtnDouble = new JButton("Double");
		jbtnSplit = new JButton("Split");
		JPanel p3 = new JPanel();
		p3.add(jbtnDeal);
		p3.add(jbtnHit);
		p3.add(jbtnStand);
		p3.add(jbtnDouble);
		p3.add(jbtnSplit);
		JButton jbtnContinue = new JButton("Continue");
		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4.add(jbtnContinue);
		lowerRightPanel.add(p3);
		lowerRightPanel.add(p4);
		lowerRightPanel.setBorder(new LineBorder(Color.BLACK, 1));
		lowerPanel.add(lowerLeftPanel);
		lowerPanel.add(lowerRightPanel);
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		mainPanel.add(imagePanel, BorderLayout.CENTER);
		imagePanel.setPreferredSize(new Dimension(300, 300));
		add(mainPanel);
	}

}
