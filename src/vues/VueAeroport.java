package vues;

import javax.swing.JPanel;

import noyau.Guichet;

public class VueAeroport extends JPanel {
	
		private Guichet guichetCourant;
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
}
