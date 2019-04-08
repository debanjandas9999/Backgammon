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
					
					if (rollnext > 0) {
						Random ra = new Random();
						Random ran = new Random();

						r1 = ra.nextInt(6) + 1;
						r2 = ran.nextInt(6) + 1;
					}

					rollnext++;

					System.out.println("control double= " + control_double);
					System.out.println("cube number= " + cube_number);
					TurnMove tu = new TurnMove(INDEX, r1, r2, control_double, cube_number);
					frame.add(tu);
					int roll_1 = tu.getChoice();
					int roll_2 = tu.getChoice2();

					frame.validate();

					Game g = new Game();
					int arr[][];
					arr = g.getARR();

					FLAG++;

					int next_move = 0;
					System.out.println("roll1" + roll_1);
					System.out.println("roll2" + roll_2);

					if (roll_1 == roll_2) {

						for (int d = 0; d < 4; d++) {
							int hy = 1;
							int hen = 24;
							int sumen = 0;
							int sumy = 0;

							for (int i = 0; i <= 6; i++) {
								sumy = sumy + arr[0][i];
							}
							for (int j = 19; j <= 24; j++) {
								sumen = sumen + arr[1][j];
							}
							sumen = sumen + arr[1][0];

							if (sumy == 15) {
								hy = 0;
							}
							if (sumen == 15) {
								hen = 25;
							}
							String st[] = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
									"", "", "", "", "", "", "" };
							int s = 0;
							if (INDEX == 0) {

								for (int x = 1; x <= 25; x++) {
									if (arr[0][x] > 0) {
										for (int m = 1; m <= 4 - d; m++) {
											if (x - (roll_1 * m) >= hy) {
												if (hy == 0 && x - (roll_1 * m) == 0) {
													st[s] = Integer.toString(x) + " " + "Off";
													s++;
												} else {

													if (arr[1][x - (roll_1 * m)] == 0) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - (roll_1 * m));
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - (roll_1 * m));
															s++;
														}
													}

													else if (arr[1][x - (roll_1 * m)] == 1) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - (roll_1 * m)) + "*";
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - (roll_1 * m)) + "*";
															s++;
														}
													}
												}
											}
										}

									}
								}
							} else {
								for (int x = 24; x > 0; x--) {

									if (arr[1][x] > 0) {
										for (int n = 1; n <= 4 - d; n++) {
											if (x + (roll_1 * n) <= hen) {
												if (hen == 25 && x + (roll_1 * n) == 25) {
													st[s] = Integer.toString(25 - x) + " " + "Off";
													s++;
												} else {
													if (arr[0][x + (roll_1 * n)] == 0) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + (roll_1 * n)));
														s++;
													} else if (arr[0][x + (roll_1 * n)] == 1) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + (roll_1 * n))) + "*";
														s++;
													}
												}
											}
										}

									}

								}

								if (arr[1][25] > 0) {
									for (int k = 1; k <= 4 - d; k++) {
										if (roll_1 * k <= 24) {
											if (arr[0][roll_1 * k] == 0) {
												st[s] = "Bar " + Integer.toString(25 - (roll_1 * k));
												s++;
											} else if (arr[0][roll_1 * k] == 1) {
												st[s] = "Bar " + Integer.toString(25 - (roll_1 * k)) + "*";
												s++;
											}

										}

									}
								}
							}

							if (s == 0) {
								infoPanel.addText("\n");
								infoPanel.addText("There are no moves available---CHANCE SKIPS!!");
								break;

							}
							char c = 'A';
							if (d == 0) {
								for (int y = 0; y < s; y++) {
									infoPanel.addText(c + ": " + st[y]);
									c++;
								}
							}
							int start_pip;
							int end_pip;

							do {
								if (d != 0) {
									infoPanel.addText("Enter the next move from the given possible moves");
									c = 'A';
									for (int y = 0; y < s; y++) {
										infoPanel.addText(c + ": " + st[y]);
										c++;
									}
								}

								String move1;
								if (s == 1) {
									move1 = "A";
									infoPanel.addText("Only one move is possible, FORCED PLAY");
								} else
									move1 = commandPanel.getCommand();

								if (move1.equalsIgnoreCase("Quit")) {

									frame.dispose();
									frame2.dispose();
									frame3.dispose();
									System.exit(0);

								}

								char alpha1 = move1.charAt(0);
								int arrnum1 = 0;

								if (alpha1 >= 65 && alpha1 <= 90)
									arrnum1 = alpha1 - 65;
								else if (alpha1 >= 97 && alpha1 <= 122)
									arrnum1 = alpha1 - 97;

								if (arrnum1 >= s) {
									infoPanel.addText("Enter move again");
									continue;
								}

								String m = st[arrnum1];
								if (m.charAt(m.length() - 1) == '*')
									m = m.substring(0, m.length() - 1);

								int space_INDEX = m.indexOf(' ');
								String first_move = m.substring(0, space_INDEX);
								String second_move = m.substring(space_INDEX + 1);

								if (first_move.equalsIgnoreCase("Bar")) {
									start_pip = 25;
									end_pip = Integer.parseInt(m.substring(space_INDEX + 1));
								} else if (second_move.equalsIgnoreCase("Off")) {
									start_pip = Integer.parseInt(m.substring(0, space_INDEX));
									end_pip = 0;
								} else {
									start_pip = Integer.parseInt(m.substring(0, space_INDEX));
									end_pip = Integer.parseInt(m.substring(space_INDEX + 1));
								}

								if (INDEX == 1) {
									start_pip = 25 - start_pip;
									end_pip = 25 - end_pip;
								}

								Game game1 = new Game(start_pip, end_pip);
								if (game1.isValid(INDEX) == true)
									break;
								else
									infoPanel.addText("Enter move again");

							} while (true);
							if (INDEX == 0) {
								if (start_pip - end_pip == (roll_1 * 2))
									d = d + 1;
								else if (start_pip - end_pip == (roll_1 * 3))
									d = d + 2;
								else if (start_pip - end_pip == (roll_1 * 4))
									d = d + 3;
							} else {
								if (end_pip - start_pip == (roll_1 * 2))
									d = d + 1;
								else if (end_pip - start_pip == (roll_1 * 3))
									d = d + 2;
								else if (end_pip - start_pip == (roll_1 * 4))
									d = d + 3;
							}

							Game game = new Game();

							if (start_pip > end_pip) {
								for (int i = start_pip; i > end_pip; i--) {

									int ar[][] = game.getARR();
									if (end_pip != 0 && ar[1][end_pip] > 0)
										game.updateArray(1, end_pip, 25);
									game.updateArray(INDEX, i, i - 1);
									Checker check = new Checker(INDEX);

									frame.add(check);
									frame.validate();
								}
							} else {
								for (int i = start_pip; i < end_pip; i++) {

									int ar[][] = game.getARR();
									if (end_pip == 25) {
										if (i == 24) {
											game.updateArray(INDEX, 24, 0);
											i++;
										}
									}
									if (i == 0) {
										game.updateArray(INDEX, 25, i + 1);
										i++;
									}
									if (end_pip != 25 && ar[0][end_pip] > 0)
										game.updateArray(0, end_pip, 25);
									if (i < end_pip)
										game.updateArray(INDEX, i, i + 1);
									Checker check = new Checker(INDEX);
									frame.add(check);
									frame.validate();
								}
							}
							int ta[][] = game.getARR();
							if (ta[0][0] == 15) {
								win = 0;
								break;
							}
							if (ta[1][0] == 15) {
								win = 1;
								break;
							}
						}
						if (win == 1 || win == 0)
							break;
					} else {

						for (int z = 0; z < 2; z++) {
							int hy = 1;
							int hen = 24;
							int sumen = 0;
							int sumy = 0;

							for (int i = 0; i <= 6; i++) {
								sumy = sumy + arr[0][i];
							}
							for (int j = 19; j <= 24; j++) {
								sumen = sumen + arr[1][j];
							}

							sumen = sumen + arr[1][0];

							if (sumy == 15) {
								hy = 0;
							}
							if (sumen == 15) {
								hen = 25;
							}

							String st[] = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
									"", "", "", "", "", "", "" };
							int s = 0;
							if (INDEX == 0) {

								for (int x = 1; x <= 25; x++) {
									if (z == 0) {
										if (arr[0][x] > 0) {

											if (x - roll_1 >= hy) {
												if (hy == 0 && x - roll_1 == 0) {
													st[s] = Integer.toString(x) + " " + "Off";
													s++;
												} else {

													if (arr[1][x - roll_1] == 0) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - roll_1);
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - roll_1);
															s++;
														}
													}

													else if (arr[1][x - roll_1] == 1) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - roll_1) + "*";
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - roll_1) + "*";
															s++;
														}
													}
												}
											}

											if (x - roll_2 >= hy) {
												if (hy == 0 && x - roll_2 == 0) {
													st[s] = Integer.toString(x) + " " + "Off";
													s++;
												} else {

													if (arr[1][x - roll_2] == 0) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - roll_2);
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - roll_2);
															s++;
														}
													}

													else if (arr[1][x - roll_2] == 1) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - roll_2) + "*";
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - roll_2) + "*";
															s++;
														}
													}
												}
											}

											if (x - roll_1 - roll_2 >= hy) {
												if (hy == 0 && x - roll_1 - roll_2 == 0) {
													st[s] = Integer.toString(x) + " " + "Off";
													s++;
												} else {
													if (arr[1][x - roll_1 - roll_2] == 0) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - roll_1 - roll_2);
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - roll_1 - roll_2);
															s++;
														}
													} else if (arr[1][x - roll_1 - roll_2] == 1) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - roll_1 - roll_2)
																	+ "*";
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - roll_1 - roll_2) + "*";
															s++;
														}
													}
												}

											}
										}
									} else if (z == 1) {
										if (arr[0][x] > 0) {
											if (x - next_move >= hy) {
												if (hy == 0 && x - next_move == 0) {
													st[s] = Integer.toString(x) + " " + "Off";
													s++;
												} else {
													if (arr[1][x - next_move] == 0) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - next_move);
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - next_move);
															s++;
														}
													} else if (arr[1][x - next_move] == 1) {
														if (x == 25) {
															st[s] = "Bar " + Integer.toString(x - next_move) + "*";
															s++;
														} else {
															st[s] = Integer.toString(x) + " "
																	+ Integer.toString(x - next_move) + "*";
															s++;
														}
													}
												}
											}
										}
									}
								}
							} else {
								for (int x = 24; x > 0; x--) {
									if (z == 0) {

										if (arr[1][x] > 0) {
											if (x + roll_1 <= hen) {
												if (hen == 25 && x + roll_1 == 25) {
													st[s] = Integer.toString(25 - x) + " " + "Off";
													s++;
												} else {
													if (arr[0][x + roll_1] == 0) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + roll_1));
														s++;
													} else if (arr[0][x + roll_1] == 1) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + roll_1)) + "*";
														s++;
													}
												}
											}

											if (x + roll_2 <= hen) {
												if (hen == 25 && x + roll_2 == 25) {
													st[s] = Integer.toString(25 - x) + " " + "Off";
													s++;
												} else {
													if (arr[0][x + roll_2] == 0) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + roll_2));
														s++;
													} else if (arr[0][x + roll_2] == 1) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + roll_2)) + "*";
														s++;
													}
												}
											}
											if (x + roll_2 + roll_1 <= hen) {
												if (hen == 25 && x + roll_1 + roll_2 == 25) {
													st[s] = Integer.toString(25 - x) + " " + "Off";
													s++;
												} else {
													if (arr[0][x + roll_2 + roll_1] == 0) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + roll_2 + roll_1));
														s++;
													} else if (arr[0][x + roll_1 + roll_2] == 1) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + roll_2 + roll_1)) + "*";
														s++;
													}
												}
											}
										}
									} else if (z == 1) {
										if (arr[1][x] > 0) {

											if (x + next_move <= hen) {
												if (hen == 25 && x + next_move == 25) {
													st[s] = Integer.toString(25 - x) + " " + "Off";
													s++;
												} else {
													if (arr[0][x + next_move] == 0) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + next_move));
														s++;
													} else if (arr[0][x + next_move] == 1) {
														st[s] = Integer.toString(25 - x) + " "
																+ Integer.toString(25 - (x + next_move)) + "*";
														s++;
													}
												}
											}
										}
									}
								}
								if (z == 0) {

									if (arr[1][25] > 0) {
										if (roll_1 <= 24) {
											if (arr[0][roll_1] == 0) {
												st[s] = "Bar " + Integer.toString(25 - roll_1);
												s++;
											} else if (arr[0][roll_1] == 1) {
												st[s] = "Bar " + Integer.toString(25 - roll_1) + "*";
												s++;
											}
										}

										if (roll_2 <= 24) {
											if (arr[0][roll_2] == 0) {
												st[s] = "Bar " + Integer.toString(25 - roll_2);
												s++;
											} else if (arr[0][roll_2] == 1) {
												st[s] = "Bar " + Integer.toString(25 - roll_2) + "*";
												s++;
											}
										}
										if (roll_2 + roll_1 <= 24) {
											if (arr[0][roll_2 + roll_1] == 0) {
												st[s] = "Bar " + Integer.toString(25 - (roll_2 + roll_1));
												s++;
											} else if (arr[0][roll_1 + roll_2] == 1) {
												st[s] = "Bar " + Integer.toString(25 - (roll_2 + roll_1)) + "*";
												s++;
											}
										}
									}
								} else if (z == 1) {
									if (arr[1][25] > 0) {
										if (next_move <= 24) {
											if (arr[0][next_move] == 0) {
												st[s] = "Bar " + Integer.toString(25 - next_move);
												s++;
											} else if (arr[0][next_move] == 1) {
												st[s] = "Bar " + Integer.toString(25 - next_move) + "*";
												s++;
											}
										}
									}
								}

							}

							if (s == 0) {
								infoPanel.addText("\n");
								infoPanel.addText("There are no moves available---CHANCE SKIPS!!");
								break;

							}
							char c = 'A';
							if (z == 0) {
								for (int y = 0; y < s; y++) {
									infoPanel.addText(c + ": " + st[y]);
									c++;
								}
							}
							int start_pip;
							int end_pip;
							System.out.println("ff");

							do {
								if (z == 1) {
									infoPanel.addText("Enter the second move from the given possible moves");
									c = 'A';
									for (int y = 0; y < s; y++) {
										infoPanel.addText(c + ": " + st[y]);
										c++;
									}
								}

								String move;
								if (s == 1) {
									move = "A";
									infoPanel.addText("Only one move is possible, FORCED PLAY");
								} else
									move = commandPanel.getCommand();

								if (move.equalsIgnoreCase("Quit")) {

									frame.dispose();
									frame2.dispose();
									frame3.dispose();
									System.exit(0);

								}
								
								char alpha = move.charAt(0);
								int arrnum = 0;

								if (alpha >= 65 && alpha <= 90)
									arrnum = alpha - 65;
								else if (alpha >= 97 && alpha <= 122)
									arrnum = alpha - 97;

								if (arrnum >= s) {
									infoPanel.addText("Enter move again");
									continue;
								}

								String m = st[arrnum];
								if (m.charAt(m.length() - 1) == '*')
									m = m.substring(0, m.length() - 1);

								int space_INDEX = m.indexOf(' ');

								String first_move = m.substring(0, space_INDEX);
								String second_move = m.substring(space_INDEX + 1);

								if (first_move.equalsIgnoreCase("Bar")) {
									start_pip = 25;
									end_pip = Integer.parseInt(m.substring(space_INDEX + 1));
								} else if (second_move.equalsIgnoreCase("Off")) {
									start_pip = Integer.parseInt(m.substring(0, space_INDEX));
									end_pip = 0;
								} else {
									start_pip = Integer.parseInt(m.substring(0, space_INDEX));
									end_pip = Integer.parseInt(m.substring(space_INDEX + 1));
								}

								if (INDEX == 1) {
									start_pip = 25 - start_pip;
									end_pip = 25 - end_pip;
								}

								if (INDEX == 0 && z == 1 && next_move != start_pip - end_pip) {
									infoPanel.addText("Not a valid move");
									continue;
								} else if (INDEX == 1 && z == 1 && next_move != end_pip - start_pip) {
									infoPanel.addText("Not a valid move");
									continue;
								}
								Game game1 = new Game(start_pip, end_pip);
								if (game1.isValid(INDEX) == true)
									break;
								else
									infoPanel.addText("Enter move again");

							} while (true);
							if (INDEX == 0) {
								if (start_pip - end_pip == roll_1)
									next_move = roll_2;
								else if (start_pip - end_pip == roll_2)
									next_move = roll_1;
								else if (start_pip - end_pip == roll_1 + roll_2)
									z++;
							} else {
								if (end_pip - start_pip == roll_1)
									next_move = roll_2;
								else if (end_pip - start_pip == roll_2)
									next_move = roll_1;
								else if (end_pip - start_pip == roll_1 + roll_2)
									z++;
							}

							Game game = new Game();

							if (start_pip > end_pip) {
								for (int i = start_pip; i > end_pip; i--) {

									int ar[][] = game.getARR();
									if (end_pip != 0 && ar[1][end_pip] > 0)
										game.updateArray(1, end_pip, 25);
									game.updateArray(INDEX, i, i - 1);
									Checker check = new Checker(INDEX);

									frame.add(check);
									frame.validate();
								}
							} else {
								for (int i = start_pip; i < end_pip; i++) {

									int ar[][] = game.getARR();
									if (end_pip == 25) {
										if (i == 24) {
											game.updateArray(INDEX, 24, 0);
											i++;
										}
									}
									if (i == 0) {
										game.updateArray(INDEX, 25, i + 1);
										i++;
									}
									if (end_pip != 25 && ar[0][end_pip] > 0)
										game.updateArray(0, end_pip, 25);
									if (i < end_pip)
										game.updateArray(INDEX, i, i + 1);
									Checker check = new Checker(INDEX);
									frame.add(check);
									frame.validate();
								}

							}
							int ta[][] = game.getARR();
							if (ta[0][0] == 15) {
								win = 0;
								if (grey_player == 1)
									Player1_points = Player1_points + cube_number;
								else if (grey_player == 2)
									Player2_points = Player2_points + cube_number;
								break;
							}
							if (ta[1][0] == 15) {
								win = 1;
								if (green_player == 1)
									Player1_points = Player1_points + cube_number;
								else if (green_player == 2)
									Player2_points = Player2_points + cube_number;
								break;
							}

						}
						if (win == 1 || win == 0)
							break;

					}
					flag++;

					infoPanel.addText("Enter next/cheat/quit for the other player's turn");
					get = commandPanel.getCommand();

					if (!get.equalsIgnoreCase("next") && !get.equalsIgnoreCase("cheat")
							&& !get.equalsIgnoreCase("quit")) {
						infoPanel.addText("Invalid Input, Enter Again");
						get = commandPanel.getCommand();
					}

					Game gg = new Game(9, 9);
					int arrr[][] = gg.getARR();

					if (get.equalsIgnoreCase("Quit")) {

						frame.dispose();
						frame2.dispose();
						frame3.dispose();
						System.exit(0);

					}
					if (get.equalsIgnoreCase("cheat")) {

						for (int i = 1; i <= 24; i++) {
							if (arrr[0][i] > 0) {
								int mm = arrr[0][i];
								for (int k = 1; k <= mm; k++) {
									gg.updateArray(0, i, 25);

								}
							}
						}

						for (int j = 1; j <= 13; j++) {
							gg.updateArray(0, 25, 0);
						}
						gg.updateArray(0, 25, 1);
						gg.updateArray(0, 25, 1);

						for (int x = 1; x <= 24; x++) {
							if (arrr[1][x] > 0) {
								int mm = arrr[1][x];
								for (int k = 1; k <= mm; k++) {
									gg.updateArray(1, x, 25);

								}
							}
						}

						for (int j = 1; j <= 13; j++) {
							gg.updateArray(1, 25, 0);
						}
						gg.updateArray(1, 25, 24);
						gg.updateArray(1, 25, 24);

						get = "next";
					}

				} while (get.equalsIgnoreCase("next"));

				if (win == 1) {
					if (green_player == 1)
						infoPanel.addText("Winner is " + FIRST_PLAYER);
					else
						infoPanel.addText("Winner is " + SECOND_PLAYER);
				} else if (win == 0) {
					if (grey_player == 1)
						infoPanel.addText("Winner is " + FIRST_PLAYER);
					else
						infoPanel.addText("Winner is " + SECOND_PLAYER);
				}

				infoPanel.addText("\n");
				infoPanel.addText("SCORE UPDATE");
				infoPanel.addText(FIRST_PLAYER + "--------- " + Player1_points);
				infoPanel.addText(SECOND_PLAYER + "--------- " + Player2_points);
				infoPanel.addText("\n");
				infoPanel.addText("\n");

				Game gl = new Game(9, 9);
				int arrr[][] = gl.getARR();

				for (int i = 1; i <= 25; i++) {
					if (arrr[0][i] > 0) {
						int mm = arrr[0][i];
						for (int k = 1; k <= mm; k++) {
							gl.updateArray(0, i, 0);
						}
					}
				}

				for (int i = 1; i <= 5; i++)
					gl.updateArray(0, 0, 6);

				for (int i = 1; i <= 3; i++)
					gl.updateArray(0, 0, 8);

				for (int i = 1; i <= 5; i++)
					gl.updateArray(0, 0, 13);

				for (int i = 1; i <= 2; i++)
					gl.updateArray(0, 0, 24);

				for (int i = 1; i <= 25; i++) {
					if (arrr[1][i] > 0) {
						int mm = arrr[1][i];
						for (int k = 1; k <= mm; k++) {
							gl.updateArray(1, i, 0);
						}
					}
				}

				for (int i = 1; i <= 2; i++)
					gl.updateArray(1, 0, 1);

				for (int i = 1; i <= 5; i++)
					gl.updateArray(1, 0, 12);

				for (int i = 1; i <= 3; i++)
					gl.updateArray(1, 0, 17);

				for (int i = 1; i <= 5; i++)
					gl.updateArray(1, 0, 19);

				if (Player1_points >= point) {
					infoPanel.addText("MATCH WINNER IS " + FIRST_PLAYER);
					break;
				}

				else if (Player2_points >= point) {
					infoPanel.addText("MATCH WINNER IS " + SECOND_PLAYER);
					break;
				}

				infoPanel.addText("Do you wish to play another game Y/N?");
				String ans = commandPanel.getCommand();

				if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
					infoPanel.addText("Invalid Input, Enter Again");
					ans = commandPanel.getCommand();
				}

				if (ans.equalsIgnoreCase("y"))
					continue;
				else
					break;

			}
			match++;

			infoPanel.addText("\n");
			infoPanel.addText("Do you wish to play a new match Y/N?");
			String ans = commandPanel.getCommand();

			if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
				infoPanel.addText("Invalid Input, Enter Again");
				ans = commandPanel.getCommand();
			}

			if (ans.equalsIgnoreCase("y"))
				continue;
			else
				break;

		}

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


