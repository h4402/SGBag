package vues;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import noyau.Tapis;
import noyau.Aeroport.Mode;

public class VueTapis extends Vue {

	private Tapis tapis;
	
	public VueTapis(VueGenerale vueGeneral, Image image, Tapis tapis) {
		super(vueGeneral, image);
		this.tapis = tapis;
		// TODO Auto-generated constructor stub
	}

	@Override
	void dessin(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	void action() {
		this.selectionner();
		vueGenerale.setGuichetCourant(null);
		vueGenerale.setTobogganCourant(null);
		vueGenerale.getChariotCourant().ajouterNoeud(this.tapis.getNoeud());
	}

	@Override
	boolean clic(int x, int y) {
		if(vueGenerale.getAeroport().getMode() == Mode.MANUEL){
			Point p = new Point(x, y);
			return dansRectangle(p);
		}
		else{
			return false;
		}
		
	}

}
