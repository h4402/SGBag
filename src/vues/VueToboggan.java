package vues;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Aeroport;
import noyau.Toboggan;
import noyau.Aeroport.Mode;

public class VueToboggan extends Vue {

	private Toboggan toboggan;
	//TODO : set from xml
	static private int tailleReelle = 2;
		
	/**
	 * Constructeur de la VueToboggan
	 * @param vueGenerale
	 * @param image
	 * @param imageSel
	 * @param toboggan
	 */
	public VueToboggan(VueGenerale vueGenerale, Image image, Image imageSel, Toboggan toboggan) {
		super(vueGenerale, image, imageSel);
		this.toboggan = toboggan;
		
		this.imageWidth = (int)Math.round(tailleReelle*vueGenerale.getEchelle());
		this.imageHeight = (int)Math.round(tailleReelle*vueGenerale.getEchelle());
		
		posPixel = new Point((int)Math.round(this.toboggan.getCoordonnees().x * this.vueGenerale.getEchelle() - imageWidth/2)
				, (int)Math.round(this.toboggan.getCoordonnees().y * this.vueGenerale.getEchelle() - imageHeight/2));
		
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth, imageHeight);
	}
	
	@Override
	void dessin(Graphics g){
		if(selection){
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(imageSel, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
		else{
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(image, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
	}
	
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(null);
		vueGenerale.setTobogganCourant(this);
		if(vueGenerale.getGuichetCourant() != null){
			vueGenerale.getGuichetCourant().selectionner();
			vueGenerale.getZoneInfo().setText("Pour ajouter un bagage cliquez sur Valider");
			vueGenerale.getBandeauAjoutBagages().setNumeros(vueGenerale.getGuichetCourant().getGuichet().getId(), 
					vueGenerale.getTobogganCourant().getToboggan().getId());
			vueGenerale.getBandeauAjoutBagages().setVisible(true);
		}
		else{
			vueGenerale.getZoneInfo().setText("Veuillez selectionner un Guichet");
		}
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		return dansRectangle(p);
	}

	public Toboggan getToboggan() {
		return toboggan;
	}
	
}
