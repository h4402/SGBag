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
	
	private Image imageAvecBagage;
	private Image imageAvecBagageSel;
	private Chariot chariot;
	
	/**
	 * Constructeur de la VueChariot
	 * @param vueGenerale
	 * @param image
	 * @param imageSel
	 * @param imageAvecBagage
	 * @param imageAvecBagageSel
	 * @param chariot
	 */
	public VueChariot(VueGenerale vueGenerale, Image image, Image imageSel, 
			Image imageAvecBagage, Image imageAvecBagageSel, Chariot chariot) {
		super(vueGenerale, image, imageSel);
		this.imageAvecBagage = imageAvecBagage;
		this.imageAvecBagageSel = imageAvecBagageSel;
		this.chariot = chariot;
		posPixel = new Point((int)Math.round(this.chariot.getCoordonnees().x * this.vueGenerale.getEchelle() - image.getWidth(vueGenerale)/2)
				, (int)Math.round(this.chariot.getCoordonnees().y * this.vueGenerale.getEchelle() - image.getHeight(vueGenerale)/2));
		rectangle = new Rectangle(posPixel.x, posPixel.y, image.getHeight(vueGenerale), image.getWidth(vueGenerale));
	}

	/**
	 * Met a jour la position du chariot et du rectangle de selection
	 * en fonction de la position de l'objet du noyau
	 */
	private void updatePos(){
		posPixel.x = (int)Math.round(chariot.getCoordonnees().x * vueGenerale.getEchelle() - image.getWidth(vueGenerale)/2);
		posPixel.y = (int)Math.round(chariot.getCoordonnees().y * vueGenerale.getEchelle() - image.getHeight(vueGenerale)/2);
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
		if(selection){
			if(chariot.getBagage() == null){
				g2d.drawImage(imageSel, posPixel.x, posPixel.y, vueGenerale);
			}
			else{
				g2d.drawImage(imageAvecBagageSel, posPixel.x, posPixel.y, vueGenerale);
			}
		}
		else{
			if(chariot.getBagage() == null){
				g2d.drawImage(image, posPixel.x, posPixel.y, vueGenerale);
			}
			else{
				g2d.drawImage(imageAvecBagage, posPixel.x, posPixel.y, vueGenerale);
			}
		}
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
