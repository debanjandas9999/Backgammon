package debback2;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class UI {

	private static final int FRAME_WIDTH = 1000;

	private static final int FRAME_HEIGHT = 800;

	private static String PROMPT = "> ";

	private JFrame frame = new JFrame();

	private InfoPanel infoPanel = new InfoPanel();

	private CommandPanel commandPanel = new CommandPanel();

	private Board board;

	UI(Board inBoard) {

		board = inBoard;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setTitle("BackGammon");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(infoPanel, BorderLayout.CENTER);

		frame.add(commandPanel, BorderLayout.SOUTH);

		frame.setResizable(false);

		frame.setVisible(true);

		return;

	}

	public void displayString(String string) {

		infoPanel.addText(string);

		return;

	}

}
