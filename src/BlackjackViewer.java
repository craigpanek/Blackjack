import javax.swing.JFrame;

public class BlackjackViewer {
	public static void main(String[] args) {
		JFrame frame = new BlackjackFrame();
		frame.setTitle("Blackjack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(700,  500);
		//frame.pack();
		frame.setVisible(true);
	}
}
