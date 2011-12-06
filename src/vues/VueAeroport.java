package vues;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import noyau.Aeroport;
import noyau.Guichet;
import noyau.Toboggan;

public class VueAeroport extends JPanel {
	
		private Guichet guichetCourant;
		private Toboggan tobogganCourant;
		private Aeroport aeroport;
		private int echelle;
		
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

		public int getEchelle() {
			return echelle;
		}

		public void setEchelle(int echelle) {
			this.echelle = echelle;
		}

		public Guichet getGuichetCourant() {
			return guichetCourant;
		}

		public void setGuichetCourant(Guichet guichetCourant) {
			this.guichetCourant = guichetCourant;
		}
				
		public void ajouterBaggage(){
			aeroport.ajouterBaggage(guichetCourant, tobogganCourant);
		}


}
