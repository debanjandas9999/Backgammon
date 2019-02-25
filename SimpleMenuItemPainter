package debback2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import debback2.Backgammon.MenuItemPainter;

public class SimpleMenuItemPainter implements MenuItemPainter {

	public Dimension getPreferredSize(Graphics2D g2d, String text) {
		return g2d.getFontMetrics().getStringBounds(text, g2d).getBounds().getSize();
	}

	@Override
	public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected, boolean isFocused) {
		FontMetrics fm = g2d.getFontMetrics();
		if (isSelected) {
			paintBackground(g2d, bounds, Color.BLUE, Color.WHITE);
		} else if (isFocused) {
			paintBackground(g2d, bounds, Color.MAGENTA, Color.BLACK);
		} else {
			paintBackground(g2d, bounds, Color.DARK_GRAY, Color.LIGHT_GRAY);
		}
		int x = bounds.x + ((bounds.width - fm.stringWidth(text)) / 2);
		int y = bounds.y + ((bounds.height - fm.getHeight()) / 2) + fm.getAscent();
		g2d.setColor(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
		g2d.drawString(text, x, y);
	}

	protected void paintBackground(Graphics2D g2d, Rectangle bounds, Color background, Color foreground) {
		g2d.setColor(background);
		g2d.fill(bounds);
		g2d.setColor(foreground);
		g2d.draw(bounds);
	}

}
