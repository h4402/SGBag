package vues;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;
	
	//TODO : set from xml
	static private double hauteurReelle = 4;
	static private double largeurReelle = 5.4;

	/**
	 * Constructeur de la VueGuichet
	 * @param vueGeneral
	 * @param image
	 * @param imageSel
	 * @param guichet
	 */
	public VueGuichet(VueGenerale vueGenerale, Image image, Image imageSel, Guichet guichet) {
		super(vueGenerale, image, imageSel);
		this.guichet = guichet;
		
		this.imageWidth = (int)Math.round(largeurReelle*vueGenerale.getEchelle());
		this.imageHeight = (int)Math.round(hauteurReelle*vueGenerale.getEchelle());
		
		posPixel = new Point((int)Math.round(this.guichet.getCoordonnees().x * this.vueGenerale.getEchelle() - imageWidth/2)
				, (int)Math.round(this.guichet.getCoordonnees().y * this.vueGenerale.getEchelle() - imageHeight/2));
		
		
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth, imageHeight);
	}
	
	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(selection){
			g2d.drawImage(imageSel, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
			//g2d.drawImage(imageSel, posPixel.x, posPixel.y,vueGenerale);
		}
		else{
			g2d.drawImage(image, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
			//g2d.drawImage(image, posPixel.x, posPixel.y,vueGenerale);
		}
	}
	
	/**
	 * Selectionne le toboggan et guichet courant et permet si possible l'ajout de bagage;
	 */
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(null);
		vueGenerale.setGuichetCourant(this);
		if(vueGenerale.getTobogganCourant() != null){
			vueGenerale.getTobogganCourant().selectionner();
			vueGenerale.getZoneInfo().setText("Pour ajouter un bagage cliquez sur Valider");
			vueGenerale.getBandeauAjoutBagages().setNumeros(vueGenerale.getGuichetCourant().getGuichet().getId(), 
					vueGenerale.getTobogganCourant().getToboggan().getId());
			vueGenerale.getBandeauAjoutBagages().setVisible(true);
		}
		else{
			vueGenerale.getZoneInfo().setText("Veuillez selectionner un toboggan");
		}
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		return dansRectangle(p);
	}

	public Guichet getGuichet() {
		return guichet;
	}

}
