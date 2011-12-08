package vues;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Aeroport.Mode;
import noyau.Aeroport;
import noyau.Chariot;
public class VueChariot extends Vue {
	private Chariot chariot;
	
	public VueChariot(VueGenerale vueGenerale, Image image, Chariot chariot) {
		super(vueGenerale, image);
		this.chariot = chariot;
		posPixel = new Point((int)Math.round(this.chariot.getCoordonnees().x * this.vueGenerale.getEchelle() - image.getHeight(vueGenerale)/2)
				, (int)Math.round(this.chariot.getCoordonnees().y * this.vueGenerale.getEchelle() - image.getWidth(vueGenerale)/2));
		rectangle = new Rectangle(posPixel.x, posPixel.y, image.getHeight(vueGenerale), image.getWidth(vueGenerale));
	}

	private void updatePos(){
		posPixel.x = (int)Math.round(chariot.getCoordonnees().x * vueGenerale.getEchelle() - image.getHeight(vueGenerale)/2);
		posPixel.y = (int)Math.round(chariot.getCoordonnees().y * vueGenerale.getEchelle() - image.getWidth(vueGenerale)/2);
		rectangle.x = posPixel.x;
		rectangle.y = posPixel.y;
	}
	
	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, posPixel.x, posPixel.y, vueGenerale);
	}

	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(this.chariot);
		vueGenerale.setGuichetCourant(null);
		vueGenerale.setTobogganCourant(null);
		vueGenerale.getBandeauVitesseChariot().setNumChariot(this.chariot.getId());
		vueGenerale.getBandeauVitesseChariot().setVitesseChariot(this.chariot.getVitesse());
		vueGenerale.getBandeauVitesseChariot().setVisible(true);
		if(Aeroport.getMode() == Mode.MANUEL){
			vueGenerale.getZoneInfo().setText("Veuillez selectionner la destination suivante du chariot.");
		}
	}
	

}
