package Backgammon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Checker extends BoardComponent implements MouseListener {

	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	public Checker() {

	}

	public Checker(int xx, int yy, int w, int h) {
		x = xx;
		y = yy;
		width = w;
		height = h;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 500, 500);
		// g2.setColor(Color.RED);
		// g2.draw(ellipse);
		// g2.fill(ellipse);
		g2.drawOval(x, y, width, height);
		g2.setColor(Color.green);
		g2.fillOval(x, y, width, height);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if (x > this.x && x < (this.x + this.width) && y > this.y && y < (this.y + this.height)) {
			this.x = 640;
			repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
