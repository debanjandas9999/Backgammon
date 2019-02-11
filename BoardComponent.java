package PraBack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BoardComponent extends JComponent{

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 10, 750, 450);
		g.setColor(new Color(97,41,253));
		g.fillRect(10, 10, 750, 450);
		
		g.setColor(new Color(230,230,250));
		g.drawRect(25, 35, 320, 400);
		g.fillRect(25, 35, 320, 400);
		
		
		g.setColor(new Color(230,230,250));
		g.drawRect(365, 35, 320, 400);
		g.fillRect(365, 35, 320, 400);
		
		g.setColor(Color.BLACK);
		g.drawRect(695, 35, 55, 190);
		g.drawRect(695, 245, 55, 190);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {25, 50, 75}, new int[] {435, 240, 435}, 3);
		g.fillPolygon(new int[] {25, 50, 75}, new int[] {435, 240, 435}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {78, 103, 128}, new int[] {435, 260, 435}, 3);
		g.fillPolygon(new int[] {78, 103, 128}, new int[] {435, 260, 435}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {131,156, 181}, new int[] {435, 240, 435}, 3);
		g.fillPolygon(new int[] {131, 156, 181}, new int[] {435, 240, 435}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {184, 209, 234}, new int[] {435, 260, 435}, 3);
		g.fillPolygon(new int[] {184, 209, 234}, new int[] {435, 260, 435}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {237,262, 287}, new int[] {435, 240, 435}, 3);
		g.fillPolygon(new int[] {237,262, 287}, new int[] {435, 240, 435}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {290, 315, 340}, new int[] {435, 260, 435}, 3);
		g.fillPolygon(new int[] {290, 315, 340}, new int[] {435, 260, 435}, 3);
		
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {365, 390, 415}, new int[] {435, 240, 435}, 3);
		g.fillPolygon(new int[] {365, 390, 415}, new int[] {435, 240, 435}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {418, 443, 468}, new int[] {435, 260, 435}, 3);
		g.fillPolygon(new int[] {418, 443, 468}, new int[] {435, 260, 435}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {471,496, 521}, new int[] {435, 240, 435}, 3);
		g.fillPolygon(new int[] {471,496, 521}, new int[] {435, 240, 435}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {524, 549, 574}, new int[] {435, 260, 435}, 3);
		g.fillPolygon(new int[] {524, 549, 574}, new int[] {435, 260, 435}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {577,602, 627}, new int[] {435, 240, 435}, 3);
		g.fillPolygon(new int[] {577,602, 627}, new int[] {435, 240, 435}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {630, 655, 680}, new int[] {435, 260, 435}, 3);
		g.fillPolygon(new int[] {630, 655, 680}, new int[] {435, 260, 435}, 3);
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {25, 50, 75}, new int[] {35, 200, 35}, 3);
		g.fillPolygon(new int[] {25, 50, 75}, new int[] {35, 200, 35}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {78, 103, 128}, new int[] {35, 220, 35}, 3);
		g.fillPolygon(new int[] {78, 103, 128}, new int[] {35, 220, 35}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {131,156, 181}, new int[] {35, 200, 35}, 3);
		g.fillPolygon(new int[] {131, 156, 181}, new int[] {35, 200, 35}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {184, 209, 234}, new int[] {35, 220, 35}, 3);
		g.fillPolygon(new int[] {184, 209, 234}, new int[] {35, 220, 35}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {237,262, 287}, new int[] {35, 200, 35}, 3);
		g.fillPolygon(new int[] {237,262, 287}, new int[] {35, 200, 35}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {290, 315, 340}, new int[] {35, 220, 35}, 3);
		g.fillPolygon(new int[] {290, 315, 340}, new int[] {35, 220, 35}, 3);
		
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {365, 390, 415}, new int[] {35, 200, 35}, 3);
		g.fillPolygon(new int[] {365, 390, 415}, new int[] {35, 200, 35}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {418, 443, 468}, new int[] {35, 220, 35}, 3);
		g.fillPolygon(new int[] {418, 443, 468}, new int[] {35, 220, 35}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {471,496, 521}, new int[] {35, 200, 35}, 3);
		g.fillPolygon(new int[] {471,496, 521}, new int[] {35, 200, 35}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {524, 549, 574}, new int[] {35, 220, 35}, 3);
		g.fillPolygon(new int[] {524, 549, 574}, new int[] {35, 220, 35}, 3);
		
		g.setColor(new Color(191,0,6));
		g.drawPolygon(new int[] {577,602, 627}, new int[] {35, 200, 35}, 3);
		g.fillPolygon(new int[] {577,602, 627}, new int[] {35, 200, 35}, 3);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawPolygon(new int[] {630, 655, 680}, new int[] {35, 220, 35}, 3);
		g.fillPolygon(new int[] {630, 655, 680}, new int[] {35, 220, 35}, 3);
		
		int fontSize = 20;
	    g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	    g.setColor(Color.black);
		
		g.drawString("7", 310, 450);
		g.drawString("8", 260, 450);
		g.drawString("9", 210, 450);
		g.drawString("10", 145, 450);
		g.drawString("11", 90, 450);
		g.drawString("12", 40, 450);

		g.drawString("24", 650, 30);
		g.drawString("23", 600, 30);
		g.drawString("22", 540, 30);
		g.drawString("21", 490, 30);
		g.drawString("20", 440, 30);
		g.drawString("19", 390, 30);
		g.drawString("18", 310, 30);
		g.drawString("17", 260, 30);
		g.drawString("16", 205, 30);
		g.drawString("15", 145, 30);
		g.drawString("14", 90, 30);
		g.drawString("13", 40, 30);

		g.drawOval(30, 390, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(30, 390, 38, 38);

		g.drawOval(30, 352, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(30, 352, 38, 38);

		g.drawOval(30, 314, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(30, 314, 38, 38);

		g.drawOval(30, 276, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(30, 276, 38, 38);

		g.drawOval(30, 238, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(30, 238, 38, 38);

		g.drawOval(30, 35, 38, 38);
		g.setColor(Color.red);
		g.fillOval(30, 35, 38, 38);

		g.drawOval(30, 73, 38, 38);
		g.setColor(Color.red);
		g.fillOval(30, 73, 38, 38);

		g.drawOval(30, 111, 38, 38);
		g.setColor(Color.red);
		g.fillOval(30, 111, 38, 38);

		g.drawOval(30, 149, 38, 38);
		g.setColor(Color.red);
		g.fillOval(30, 149, 38, 38);

		g.drawOval(370, 35, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(370, 35, 38, 38);

		g.drawOval(370, 73, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(370, 73, 38, 38);

		g.drawOval(370, 111, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(370, 111, 38, 38);

		g.drawOval(370, 149, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(370, 149, 38, 38);

		g.drawOval(370, 187, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(370, 187, 38, 38);

		g.drawOval(370, 390, 38, 38);
		g.setColor(Color.red);
		g.fillOval(370, 390, 38, 38);

		g.drawOval(370, 352, 38, 38);
		g.setColor(Color.red);
		g.fillOval(370, 352, 38, 38);

		g.drawOval(370, 314, 38, 38);
		g.setColor(Color.red);
		g.fillOval(370, 314, 38, 38);

		g.drawOval(370, 276, 38, 38);
		g.setColor(Color.red);
		g.fillOval(370, 276, 38, 38);

		g.drawOval(370, 238, 38, 38);
		g.setColor(Color.red);
		g.fillOval(370, 238, 38, 38);

		g.drawOval(240, 390, 38, 38);
		g.setColor(Color.red);
		g.fillOval(240, 390, 38, 38);

		g.drawOval(240, 352, 38, 38);
		g.setColor(Color.red);
		g.fillOval(240, 352, 38, 38);

		g.drawOval(240, 314, 38, 38);
		g.setColor(Color.red);
		g.fillOval(240, 314, 38, 38);

		g.drawOval(240, 35, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(240, 35, 38, 38);

		g.drawOval(240, 73, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(240, 73, 38, 38);

		g.drawOval(240, 111, 38, 38);
		g.setColor(Color.ORANGE);
		g.fillOval(240, 111, 38, 38);

		g.drawOval(640, 35, 38, 38);
		g.setColor(Color.red);
		g.fillOval(640, 35, 38, 38);

		g.drawOval(640, 73, 38, 38);
		g.setColor(Color.red);
		g.fillOval(640, 73, 38, 38);

		g.drawOval(640, 390, 38, 38);
		g.setColor(Color.orange);
		g.fillOval(640, 390, 38, 38);

		g.drawOval(640, 352, 38, 38);
		g.setColor(Color.orange);
		g.fillOval(640, 352, 38, 38);
	}

}
	   
	   
		
