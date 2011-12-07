package vues;

import javax.swing.JPanel;

import org.w3c.dom.Document;

import noyau.Aeroport;
import noyau.Guichet;
import noyau.Toboggan;

public class VueAeroport extends JPanel {
	
		private Guichet guichetCourant;
		private Toboggan tobogganCourant;
		private Aeroport aeroport;
		private int echelle;

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
				
		public void ajouterBagage(){
			aeroport.ajouterBagage(guichetCourant, tobogganCourant);
		}
		
}
