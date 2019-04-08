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

import javafx.scene.text.Text;

public class Backgammon {

	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	public static int DICE_ROLL_1;
	public static int DICE_ROLL_2;
	public static int AssignColor;
	public static int INDEX;

	public static String FIRST_PLAYER;
	public static String SECOND_PLAYER;
	public static int FLAG = 0;
	public static int FLAG2 = 0;
//	public static int win = -1;
	public static int DOUBLE_CUBE = 0;
	public static int Player1_points = 0;
	public static int Player2_points = 0;
	public static int cube_number = 1;
	static Text[] displayTime = new Text[8];

	public interface MenuItemPainter {

		public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected, boolean isFocused);

		public Dimension getPreferredSize(Graphics2D g2d, String text);

	}

	private static JFrame frame3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		JFrame frame2 = new JFrame();
		JFrame frame3 = new JFrame();

		InfoPanel infoPanel = new InfoPanel();

		infoPanel.addText("WELCOME TO BACKGAMMON");

		CommandPanel commandPanel = new CommandPanel();
		frame.setBounds(0, 0, 1145, 520);
		Board b = new Board();

		frame.revalidate();
		frame.repaint();

		frame3.setBounds(100, 100, 730, 489);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(128, 28, 86, 20);
		frame3.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblName = new JLabel("Player 1:");
		lblName.setBounds(65, 31, 56, 14);
		frame3.getContentPane().add(lblName);

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
					frame.setVisible(true);
					frame.repaint();
					frame.revalidate();
					frame2.setVisible(false);
					frame2.repaint();
					frame2.revalidate();
					frame3.setVisible(false);
					frame3.repaint();
					frame3.revalidate();

				}
				FLAG2++;

				FIRST_PLAYER = textField.getText();
				SECOND_PLAYER = textField_1.getText();
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
				frame2.add(new AnnouncementPane(frame, frame2, frame3));
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
		int match = 0;

		while (true) {
			if (match != 0) {
				infoPanel.addText("Enter Player 1");
				FIRST_PLAYER = commandPanel.getCommand();
				infoPanel.addText("Enter Player 2");
				SECOND_PLAYER = commandPanel.getCommand();
			}

			Player1_points = 0;
			Player2_points = 0;
			infoPanel.addText("How much points do you wish to play?");
			String play_point = commandPanel.getCommand();
			infoPanel.addText("POINTS: " + play_point);
			int point = Integer.parseInt(play_point);

			int craw = 0;

			while (true) {

				DOUBLE_CUBE = 0;
				if (craw == 0) {
					if (Player1_points + 1 == point || Player2_points + 1 == point) {
						infoPanel.addText("CRAWFORD RULE ACTIVE FOR THIS GAME");
						craw = 1;
						DOUBLE_CUBE = 2;
					}
				}

				int control_double = -1;
				int win = -1;

				Random randi = new Random();
				Random randy = new Random();

				int r1 = randi.nextInt(6) + 1;
				int r2 = randy.nextInt(6) + 1;
				while (r1 == r2) {
					r1 = randi.nextInt(6) + 1;
					r2 = randy.nextInt(6) + 1;
				}

				TurnMove tut = new TurnMove(INDEX, r1, r2, control_double, cube_number);

				frame.add(tut);
				int roll1 = tut.getChoice();
				int roll2 = tut.getChoice2();
				DICE_ROLL_1 = roll1;
				DICE_ROLL_2 = roll2;

				frame.validate();

				infoPanel.addText("Player 1: " + FIRST_PLAYER);
				infoPanel.addText("Player 2: " + SECOND_PLAYER);

				int grey_player = 0;
				int green_player = 0;

				if (DICE_ROLL_1 > DICE_ROLL_2) {
					infoPanel.addText(FIRST_PLAYER + " --> " + "Grey");
					infoPanel.addText(SECOND_PLAYER + " --> " + " Green");
					grey_player = 1;
					green_player = 2;
					String message = FIRST_PLAYER + " " + "makes the first move";
					infoPanel.addText(message);
				}
				if (DICE_ROLL_2 > DICE_ROLL_1) {
					infoPanel.addText(SECOND_PLAYER + " --> " + "Grey");
					infoPanel.addText(FIRST_PLAYER + " --> " + " Green");
					grey_player = 2;
					green_player = 1;

					String message = SECOND_PLAYER + " " + "makes the first move";
					infoPanel.addText(message);

				}
				System.out.println("greyplayer " + grey_player);
				System.out.println("greenplayer " + green_player);
				int rollnext = 0;
				int flag = 2;
				String get = " ";
				INDEX = 0;
				cube_number = 1;

				do {

					String message_1 = FIRST_PLAYER + "'s turn:";
					String message_2 = SECOND_PLAYER + "'s turn:";
					System.out.println("flag = " + flag);
					if (flag % 2 == 0) {
						if (flag != 2) {
							INDEX = 0;
							infoPanel.addText("\n");
							if (grey_player == 1)
								infoPanel.addText(message_1);
							else
								infoPanel.addText(message_2);
						}
					}

					else {

						INDEX = 1;
						infoPanel.addText("\n");
						if (green_player == 1)
							infoPanel.addText(message_1);
						else
							infoPanel.addText(message_2);
					}
					System.out.println("index is " + INDEX);

					if (DOUBLE_CUBE == 0 && flag != 2) {
						if (control_double == -1 || control_double == INDEX) {
							infoPanel.addText("Enter double to throw a doubling cube or enter any key to continue");
							if (commandPanel.getCommand().equalsIgnoreCase("Double")) {
								DOUBLE_CUBE = 1;
								flag++;
								continue;
							}
						}
					}

					if (DOUBLE_CUBE == 1) {
						infoPanel.addText("Do you want to accept the cube Y/N?");
						String decision = commandPanel.getCommand();
						if (decision.equalsIgnoreCase("N")) {
							if (INDEX == 0) {
								if (grey_player == 1)
									Player2_points = Player2_points + cube_number;
								else if (grey_player == 2)
									Player1_points = Player1_points + cube_number;

								win = 1;
							}

							else {
								if (green_player == 1)
									Player2_points = Player2_points + cube_number;
								else if (green_player == 2)
									Player1_points = Player1_points + cube_number;

								win = 0;
							}

							System.out.println("win " + win);
							System.out.println("player 1 points " + Player1_points);
							System.out.println("player 2 points " + Player2_points);
							DOUBLE_CUBE = 0;
							break;
						} else if (decision.equalsIgnoreCase("Y")) {
							cube_number = cube_number * 2;
							control_double = INDEX;
							flag++;
							DOUBLE_CUBE = 0;
							infoPanel.addText("\n");
							if (INDEX == 0) {
								if (grey_player == 1)
									infoPanel.addText("NOW " + FIRST_PLAYER + " HAS THE DOUBLING CUBE");
								else if (grey_player == 2)
									infoPanel.addText("NOW " + SECOND_PLAYER + " HAS THE DOUBLING CUBE");
							}

							else {
								if (green_player == 1)
									infoPanel.addText("NOW " + FIRST_PLAYER + " HAS THE DOUBLING CUBE");
								else if (green_player == 2)
									infoPanel.addText("NOW " + SECOND_PLAYER + " HAS THE DOUBLING CUBE");
							}

							continue;
						}

					}

