package debback2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Checker extends JPanel {

	// private Graphics g;
	// public Checker()
	static int FLAG = 0;
	int PIP;

	// Game board = new Game();
	private int[][] arra; // = board.getARR();

	// public Graphics g;

	public void paintComponent(Graphics g) {

		if (FLAG == 0) {
			Board board = new Board();
			arra = board.getArray();
		} else {
			Game board = new Game();
			arra = board.getARR();
		}

		FLAG = FLAG + 1;

		g.drawRect(10, 10, 780, 450);
		g.setColor(new Color(97, 41, 253));
		g.fillRect(10, 10, 780, 450);

		g.setColor(new Color(230, 230, 250));
		g.drawRect(25, 35, 320, 400);
		g.fillRect(25, 35, 320, 400);

		g.setColor(new Color(230, 230, 250));
		g.drawRect(390, 35, 320, 400);
		g.fillRect(390, 35, 320, 400);

		g.setColor(Color.BLACK);
		g.drawRect(720, 35, 55, 190);
		g.drawRect(720, 245, 55, 190);

		drawPipsDown(g);
		drawPipsUP(g);
		drawCheckers(g);

		if (PIP == 1)
			numberPip2(g);
		else if (PIP == 0)
			numberPip1(g);
	}

	private void numberPip2(Graphics g) { // paints the numbers on the board
		// TODO Auto-generated method stub
		g.drawString("24", 680, 450);
		g.drawString("23", 630, 450);
		g.drawString("22", 575, 450);
		g.drawString("21", 520, 450);
		g.drawString("20", 460, 450);
		g.drawString("19", 410, 450);
		g.drawString("18", 310, 450);
		g.drawString("17", 260, 450);
		g.drawString("16", 210, 450);
		g.drawString("15", 145, 450);
		g.drawString("14", 90, 450);
		g.drawString("13", 40, 450);

		g.drawString("1", 680, 30);
		g.drawString("2", 630, 30);
		g.drawString("3", 575, 30);
		g.drawString("4", 520, 30);
		g.drawString("5", 460, 30);
		g.drawString("6", 410, 30);
		g.drawString("7", 310, 30);
		g.drawString("8", 260, 30);
		g.drawString("9", 205, 30);
		g.drawString("10", 145, 30);
		g.drawString("11", 90, 30);
		g.drawString("12", 40, 30);

	}

	private void numberPip1(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("1", 680, 450);
		g.drawString("2", 630, 450);
		g.drawString("3", 575, 450);
		g.drawString("4", 520, 450);
		g.drawString("5", 460, 450);
		g.drawString("6", 410, 450);
		g.drawString("7", 310, 450);
		g.drawString("8", 260, 450);
		g.drawString("9", 210, 450);
		g.drawString("10", 145, 450);
		g.drawString("11", 90, 450);
		g.drawString("12", 40, 450);

		g.drawString("24", 680, 30);
		g.drawString("23", 630, 30);
		g.drawString("22", 575, 30);
		g.drawString("21", 520, 30);
		g.drawString("20", 460, 30);
		g.drawString("19", 410, 30);
		g.drawString("18", 310, 30);
		g.drawString("17", 260, 30);
		g.drawString("16", 205, 30);
		g.drawString("15", 145, 30);
		g.drawString("14", 90, 30);
		g.drawString("13", 40, 30);
	}

	private void drawCheckers(Graphics g) { // paints the checkers
		// TODO Auto-generated method stub
		Color colour;
		for (int i = 0; i < 2; i++) {
			int xl = 665;
			int xu = 29;

			if (i == 0)
				colour = Color.GRAY;
			else
				colour = Color.GREEN;
			for (int b = 1; b < 25; b++) {
				int j = arra[i][b];

				int yl = 400;
				int yu = 35;
				int radius = 35;
				if (b <= 12) {
					if (b == 7)
						xl = xl - 53;

					while (j != 0) {
						g.drawOval(xl, yl, radius, radius);
						g.setColor(colour);
						g.fillOval(xl, yl, radius, radius);

						yl = yl - 35;
						j--;
					}
					xl = xl - 53;
				}

				else {
					if (b == 19)
						xu = xu + 53;
					while (j != 0) {
						g.drawOval(xu, yu, radius, radius);
						g.setColor(colour);
						g.fillOval(xu, yu, radius, radius);

						yu = yu + 35;
						j--;

					}
					xu = xu + 53;
				}
			}
		}

	}

	private void drawPipsUP(Graphics g) {

		// TODO Auto-generated method stub
		int x1 = 25;
		int y1 = 35;
		int x2 = 50;
		int y2 = 220;
		int x3 = 75;
		int y3 = 35;

		int a1 = 78;
		int b1 = 35;
		int a2 = 103;
		int b2 = 220;
		int a3 = 128;
		int b3 = 35;

		for (int i = 1; i <= 12; i++) {
			if (i == 7) {
				x1 = x1 + 50;
				x2 = x2 + 50;
				x3 = x3 + 50;
				a1 = a1 + 50;
				a2 = a2 + 50;
				a3 = a3 + 50;
			}
			if (i % 2 == 0) {
				g.setColor(Color.BLACK);
				g.drawPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
				g.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
				x1 = x1 + 106;
				x2 = x2 + 106;
				x3 = x3 + 106;

			} else {
				g.setColor(Color.RED);
				g.drawPolygon(new int[] { a1, a2, a3 }, new int[] { y1, y2, y3 }, 3);
				g.fillPolygon(new int[] { a1, a2, a3 }, new int[] { y1, y2, y3 }, 3);
				a1 = a1 + 106;
				a2 = a2 + 106;
				a3 = a3 + 106;
			}
		}
	}

	private void drawPipsDown(Graphics g) {
		// TODO Auto-generated method stub
		int x1 = 25;
		int y1 = 435;
		int x2 = 50;
		int y2 = 250;
		int x3 = 75;
		int y3 = 435;

		int a1 = 78;
		int b1 = 435;
		int a2 = 103;
		int b2 = 250;
		int a3 = 128;
		int b3 = 435;

		for (int i = 1; i <= 12; i++) {
			if (i == 7) {
				x1 = x1 + 50;
				x2 = x2 + 50;
				x3 = x3 + 50;
				a1 = a1 + 50;
				a2 = a2 + 50;
				a3 = a3 + 50;
			}
			if (i % 2 == 0) {
				g.setColor(Color.RED);
				g.drawPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
				g.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
				x1 = x1 + 106;
				x2 = x2 + 106;
				x3 = x3 + 106;

			} else {
				g.setColor(Color.BLACK);
				g.drawPolygon(new int[] { a1, a2, a3 }, new int[] { y1, y2, y3 }, 3);
				g.fillPolygon(new int[] { a1, a2, a3 }, new int[] { y1, y2, y3 }, 3);
				a1 = a1 + 106;
				a2 = a2 + 106;
				a3 = a3 + 106;
			}
		}
	}

}
