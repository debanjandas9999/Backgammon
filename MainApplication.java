package Backgammon;

import javax.swing.JFrame;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game");
		frame.setResizable(true);
		BoardComponent board = new BoardComponent();

		frame.add(board);
		Checker checker = new Checker(30, 187, 38, 38);
		frame.add(checker);

		checker.addMouseListener(checker);

		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
	}

}
