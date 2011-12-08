package vues;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import noyau.Aeroport;
import noyau.Tapis;
import noyau.Aeroport.Mode;

public class VueTapis extends Vue {

	private Tapis tapis;
	private Image imageAvecBagage;
	private Image imageAvecBagageSel;
	
	public VueTapis(VueGenerale vueGeneral, Image image, Image imageSel, 
			Image imageAvecBagage, Image imageAvecBagageSel, Tapis tapis) {
		super(vueGeneral, image, imageSel);
		this.tapis = tapis;
		this.imageAvecBagage = imageAvecBagage;
		this.imageAvecBagageSel = imageAvecBagageSel;
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
		if(Aeroport.getMode() == Mode.MANUEL){
			Point p = new Point(x, y);
			return dansRectangle(p);
		}
		else{
			return false;
		}
		
	}

}
