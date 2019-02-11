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
	   
	   
		
