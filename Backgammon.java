package debback2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Backgammon {

	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	public static int DICE_ROLL_1;
	public static int DICE_ROLL_2;

	public static String FIRST_PLAYER;
	public static String SECOND_PLAYER;
	static TurnMove t = new TurnMove(); // an object t of the turnmove class has been created to access the dice in the
										// main class.

	public interface MenuItemPainter {

		public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected, boolean isFocused);

		public Dimension getPreferredSize(Graphics2D g2d, String text);

	}

	private static JFrame frame3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start_pip;
		int end_pip;

		JFrame frame = new JFrame(); // frame for the board
		JFrame frame2 = new JFrame(); // frame for the start screen.
		JFrame frame3 = new JFrame(); // frame for the screen to add player inputs
//		frame.setLayout(new BorderLayout());

		InfoPanel infoPanel = new InfoPanel(); // creates an object of infopanel to add the infopanel in the board
		infoPanel.addText("WELCOME TO BACKGAMMON"); // gets printed on the infopanel
		// infoPanel.addText("");

		CommandPanel commandPanel = new CommandPanel(); // creates an object of commandpanel to add the commmandpanel in
														// the board
		frame.setBounds(0, 0, 1200, 530);
		Board b = new Board();
		// Checker ch = new Checker();
		// TurnMove t = new TurnMove();

		// frame.add(ch);
		// frame.add(t);
		frame.revalidate();
		frame.repaint();
		// System.out.println(t.getChoice());

		frame3.setBounds(100, 100, 730, 489);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(128, 28, 86, 20);
		frame3.getContentPane().add(textField); // a new textfield is created to take inputs from Player 1
		textField.setColumns(10);

		JLabel lblName = new JLabel("Player 1:");
		lblName.setBounds(65, 31, 56, 14);
		frame3.getContentPane().add(lblName); // a label is added beside the textfield

		JLabel lblPhone = new JLabel("Player 2:");
		lblPhone.setBounds(65, 68, 56, 14);
		frame3.getContentPane().add(lblPhone);

		textField_1 = new JTextField();
		textField_1.setBounds(128, 65, 86, 20);
		frame3.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("submit");

		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(65, 387, 89, 23);
		frame3.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(arg0.getActionCommand());
				if (textField.getText().isEmpty() || (textField_1.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Data Missing");
				} else if (textField.getText().equalsIgnoreCase(textField_1.getText())) {
					JOptionPane.showMessageDialog(null, "Both Player Names cannot be the same");
				} else {
					frame.setVisible(true); // redirects to the board frame
					frame.repaint();
					frame.revalidate();
					frame2.setVisible(false);
					frame2.dispose(); // closes frame 2
					frame2.repaint();
					frame2.revalidate();
					frame3.setVisible(false);
					frame3.dispose(); // closes frame 3
					frame3.repaint();
					frame3.revalidate();

					frame.getContentPane().add(t);
					frame.getContentPane().validate();
					frame.repaint();
					frame.revalidate();
					int choice1 = t.getChoice();
					int choice2 = t.getChoice2();
					DICE_ROLL_1 = choice1;
					DICE_ROLL_2 = choice2;
				}

				String name_1 = textField.getText(); // gets the input from the textfield to display it on infopanel
				String name_2 = textField_1.getText();
				infoPanel.addText("Player1 : " + " " + name_1);
				infoPanel.addText("player2 : " + " " + name_2);

				Random rand = new Random();
				int ch;
				ch = rand.nextInt(2) + 1;
				if (ch == 1) {
					infoPanel.addText(name_1 + " --> " + "Green");
					infoPanel.addText(name_2 + " --> " + " Grey");
				} else if (ch == 2) {
					infoPanel.addText(name_1 + " --> " + "Grey");
					infoPanel.addText(name_2 + " --> " + "Green");
				}

				if (DICE_ROLL_1 > DICE_ROLL_2) { // compares the dice values and accordingly prints whose move it is.
					String message = name_1 + " " + "makes the first move";
					infoPanel.addText(message);
					FIRST_PLAYER = name_1;
					SECOND_PLAYER = name_2;
					frame.add(infoPanel, BorderLayout.EAST);
				}
				if (DICE_ROLL_2 > DICE_ROLL_1) {
					String message = name_2 + " " + "makes the first move";
					infoPanel.addText(message);
					FIRST_PLAYER = name_2;
					SECOND_PLAYER = name_1;
					frame.add(infoPanel, BorderLayout.EAST);
				}

				String message_3 = "Enter the move on the command panel. For example, if you enter 6 4, the checker moves from pip 6 to pip 4. After entering the move, enter next to move on to the next player's move. Ater that, if you enter quit instead of a value, the application terminates. ";
				infoPanel.addText(message_3);
			};

		});

		frame.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.add(new AnnouncementPane(frame, frame2, frame3)); // calls the AnnouncementPane
				frame2.pack();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});

		frame.add(infoPanel, BorderLayout.EAST);

		frame.add(commandPanel, BorderLayout.SOUTH);

		frame.setResizable(false);

		frame.revalidate();
		frame.repaint();
//

//		int initial_start = 0;
//		int initial_end = 0;
		int flag = 2;
		int initial_start = 0;
		int initial_end = 0;

		do {
			int index = 0;
			System.out.println("in DO");
			String message_1 = FIRST_PLAYER + "'s turn:";
			String message_2 = SECOND_PLAYER + "'s turn:";

			if (flag % 2 == 0) {
				infoPanel.addText(message_1);
			} else {
				infoPanel.addText(message_2);
				index = 1;
			}

			do {
				System.out.println("in dodo");

				String move = commandPanel.getCommand(); // gets the command stored in a string

				if (move.equalsIgnoreCase("Quit")) {

					frame.dispose();
					frame2.dispose();
					frame3.dispose();
					System.exit(0);

				}
//     			start_pip = Character.getNumericValue(move.charAt(0));
//				end_pip = Character.getNumericValue(move.charAt(2));
				int space_index = move.indexOf(' ');
				start_pip = Integer.parseInt(move.substring(0, space_index));
				end_pip = Integer.parseInt(move.substring(space_index + 1));

				t.setDiceValues(start_pip, end_pip); // calls the function to roll the dice again with new values
				t.repaint();
				frame.revalidate();
				frame.repaint();

				Game game1 = new Game(start_pip, end_pip);
				if (game1.isValid(index) == true) {
					break;
				} else {
					infoPanel.addText("Enter move again");
				}

			} while (true == true);

			Game game = new Game(start_pip, end_pip);

			if (start_pip > end_pip) {
				for (int i = start_pip; i > end_pip; i--) {
					game.updateArray(index, i, i - 1);
					Checker check = new Checker();
					frame.add(check);
					frame.repaint();
					frame.revalidate();
				}
			} else {
				for (int i = start_pip; i < end_pip; i++) {
					game.updateArray(index, i, i + 1);
					int ar[][] = game.getARR();
					Checker check = new Checker();
					frame.add(check);
					frame.repaint();
					frame.revalidate();
				}

			}

			initial_start = start_pip;
			initial_end = end_pip;

			flag++;

		} while (commandPanel.getCommand().equalsIgnoreCase("next"));

		System.out.println("out DO");

		frame.revalidate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.revalidate();
		frame.repaint();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Backgammon window = new Backgammon();
					// window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
