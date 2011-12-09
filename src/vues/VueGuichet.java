package vues;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;

	/**
	 * Constructeur de la VueGuichet
	 * @param vueGeneral
	 * @param image
	 * @param imageSel
	 * @param guichet
	 */
	public VueGuichet(VueGenerale vueGeneral, Image image, Image imageSel, Guichet guichet) {
		super(vueGeneral, image, imageSel);
		this.guichet = guichet;
		posPixel = new Point((int)Math.round(this.guichet.getCoordonnees().x * this.vueGenerale.getEchelle() - imageWidth/2)
				, (int)Math.round(this.guichet.getCoordonnees().y * this.vueGenerale.getEchelle() - imageHeight/2));
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth, imageHeight);
	}
	
	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(selection){
			g2d.drawImage(imageSel, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
		else{
			g2d.drawImage(image, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
	}
	
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(null);
		vueGenerale.setGuichetCourant(guichet);
		if(vueGenerale.getTobogganCourant() != null){
			vueGenerale.getZoneInfo().setText("Pour ajouter un bagage cliquez sur Valider");
			vueGenerale.getBandeauAjoutBagages().setNumeros(vueGenerale.getGuichetCourant().getId(), 
					vueGenerale.getTobogganCourant().getId());
			vueGenerale.getBandeauAjoutBagages().setVisible(true);
		}
		else{
			vueGenerale.getZoneInfo().setText("Veuillez sélectionner un toboggan");
		}
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		return dansRectangle(p);
	}

}
