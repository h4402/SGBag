package vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.geom.Point2D;
import noyau.Aeroport.Mode;
import noyau.Aeroport;
import noyau.Chariot;
import noyau.Noeud;
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
		posPixel = new Point((int)Math.round(this.chariot.getCoordonnees().x * this.vueGenerale.getEchelle() - imageWidth/2)
				, (int)Math.round(this.chariot.getCoordonnees().y * this.vueGenerale.getEchelle() - imageHeight/2));
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageHeight, imageWidth);
	}

	/**
	 * Met a jour la position du chariot et du rectangle de selection
	 * en fonction de la position de l'objet du noyau
	 */
	private void updatePos(){
		posPixel.x = (int)Math.round(chariot.getCoordonnees().x * vueGenerale.getEchelle() - imageWidth/2);
		posPixel.y = (int)Math.round(chariot.getCoordonnees().y * vueGenerale.getEchelle() - imageHeight/2);
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageHeight, imageWidth);
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
                double alpha = 0;
		updatePos();
                if(chariot.getProchainNoeud() != null){
                    alpha = calculerAngleTour(chariot.getProchainNoeud());
                    g2d.rotate(alpha,posPixel.x+imageWidth/2, posPixel.y+imageHeight/2);
                }
		if(chariot.getDestination() != null || chariot.getCoordonnees().x != 0 || chariot.getCoordonnees().y != 0){
			if(selection){
				if(chariot.getBagage() == null){
					g2d.drawImage(imageSel, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
				}
				else{
					g2d.drawImage(imageAvecBagageSel, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
                            }
                        }
			else{
				if(chariot.getBagage() == null){
					g2d.drawImage(image, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
                                }
				else{
					g2d.drawImage(imageAvecBagage, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
				}
			}
		}
                g2d.rotate(-alpha, chariot.getCoordonnees().x, chariot.getCoordonnees().y);
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

    private double calculerAngleTour(Noeud prochainNoeud) {
        double xAux = (int)Math.round(prochainNoeud.getCoordonnees().x*vueGenerale.getEchelle() - imageWidth/2);
        double yAux = (int)Math.round(prochainNoeud.getCoordonnees().y*vueGenerale.getEchelle() - imageHeight/2);
        Point2D.Double prochain = new Point2D.Double(xAux, yAux);
        Point2D.Double vector_director = new Point2D.Double(prochain.getX()-posPixel.x,prochain.getY()-posPixel.y);
        double angle = Math.acos((vector_director.getX())/(Math.sqrt( Math.pow(vector_director.getX(), 2) + Math.pow(vector_director.getY(), 2 )))*(Math.sqrt(1)));
        return angle;
    }
	

}
