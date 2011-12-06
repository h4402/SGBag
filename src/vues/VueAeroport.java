package vues;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VueAeroport extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		// TODO : a enlever
		g.setColor(Color.white);
		// On efface l'écran
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
		g.drawOval(50, 50, 50, 50);
		g.fillOval(150, 150, 50, 50);
		g.drawRect(200, 50, 200, 200);
		
		
	}
	
}
