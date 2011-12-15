package vues;

import ihm.ImagesManager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.geom.AffineTransform;
import noyau.Aeroport.Mode;
import noyau.Aeroport;
import noyau.Chariot;
import noyau.Noeud;

public class VueChariot extends Vue {

	/**
	 * Objet Chariot du noyau a representer
	 */
	private Chariot chariot;

	/**
	 * Angle avec lequel il faut dessiner le chariot
	 */
	private double alpha;

	/**
	 * Largeur en metre de la representation chariot Sert de base de reference
	 * pour le calcul avec l'echelle
	 */
	static private double longueurReelle = 1.5;

	/**
	 * Hauteur en metre de la representation chariot Sert de base de reference
	 * pour le calcul avec l'echelle
	 */
	static private double largeurReelle = 3;

	/**
	 * Constructeur de la VueChariot
	 * 
	 * @param vueGenerale : VueGenerale qui possede les informations sur l'etat de l'interface
	 * @param imagesManager : Gestionnaire des images utilisees pour dessiner les Vues
	 * @param chariot : Objet Chariot du noyau a representer 
	 */
	public VueChariot(VueGenerale vueGenerale, ImagesManager imagesManager,
			Chariot chariot) {
		super(vueGenerale, imagesManager);
		this.chariot = chariot;
		this.alpha = 0;
		this.imageWidth = (int) Math.round(largeurReelle
				* vueGenerale.getEchelle());
		this.imageHeight = (int) Math.round(longueurReelle
				* vueGenerale.getEchelle());

		posPixel = new Point((int) Math.round(this.chariot.getCoordonnees().x
				* this.vueGenerale.getEchelle() - imageWidth / 2),
				(int) Math.round(this.chariot.getCoordonnees().y
						* this.vueGenerale.getEchelle() - imageHeight / 2));

		rectangle = new Rectangle(posPixel.x, posPixel.y, imageHeight,
				imageWidth);
	}

	/**
	 * Met a jour la position du chariot et du rectangle de selection en
	 * fonction de la position de l'objet du noyau
	 */
	private void updatePos() {
		posPixel.x = (int) Math.round(chariot.getCoordonnees().x
				* vueGenerale.getEchelle() - imageWidth / 2);
		posPixel.y = (int) Math.round(chariot.getCoordonnees().y
				* vueGenerale.getEchelle() - imageHeight / 2);
		calculerAngleTour();
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth,
				imageHeight);
		AffineTransform rotation = AffineTransform.getRotateInstance(alpha,
				posPixel.x + imageWidth / 2, posPixel.y + imageHeight / 2);
		rectangle = rotation.createTransformedShape(rectangle);
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

	/**
	 * Dessine le chariot dans le style selectione et affiche des informations
	 * sur sa destination
	 * 
	 * @param g2d
	 */
	private void dessinSel(Graphics2D g2d) {
		if (chariot.getBagage() == null) {
			g2d.drawImage(imagesManager.getImgChariotSel(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
			if (chariot.getDestination() != null) {
				vueGenerale.getZoneInfo().setText(
						"Chariot " + chariot.getId() + " Destination Noeud "
								+ chariot.getDestination().getId());
			} else {
				vueGenerale.getZoneInfo().setText(
						"Chariot " + chariot.getId()
								+ " Destination : inconnue");
			}
		} else {
			g2d.drawImage(imagesManager.getImgChariotBSel(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
			if (chariot.getDestination() != null) {
				vueGenerale.getZoneInfo().setText(
						"<html>Chariot "
								+ chariot.getId()
								+ " Destination Noeud "
								+ chariot.getDestination().getId()
								+ "<br> Bagage a destination du toboggan "
								+ chariot.getBagage().getTogobban().getNoeud()
										.getId() + "</html>");
			} else {
				vueGenerale.getZoneInfo().setText(
						"Chariot " + chariot.getId()
								+ " Destination : inconnue");
			}
		}
	}

	/**
	 * Dessine le chariot dans le style non selectione
	 * 
	 * @param g2d
	 */
	private void dessinNonSel(Graphics2D g2d) {
		if (chariot.getBagage() == null) {
			g2d.drawImage(imagesManager.getImgChariot(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
		} else {
			g2d.drawImage(imagesManager.getImgChariotB(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
	}

	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		updatePos();
		g2d.rotate(alpha, posPixel.x + imageWidth / 2, posPixel.y + imageHeight
				/ 2); // On tourne le graphics pour dessiner le chariot avec un
						// angle alpha
		if (chariot.getCoordonnees().x != 0 || chariot.getCoordonnees().y != 0) {
			if (selection) {
				dessinSel(g2d);
			} else {
				dessinNonSel(g2d);
			}
			if (chariot.getFreine()) {
				g2d.drawImage(imagesManager.getImgEtincelles(), posPixel.x
						- imageWidth / 4, posPixel.y - imageHeight / 3,
						(int) Math.round(imageWidth * 0.5),
						(int) Math.round(imageHeight * 1.5), vueGenerale);
			}
		}
		g2d.rotate(-alpha, posPixel.x + imageWidth / 2, posPixel.y
				+ imageHeight / 2); // On tourne le graphics de -alpha pour
									// remettre le dessin droit
	}

	/**
	 * Action effectue apres un clic sur le chariot, Affiche le menu de
	 * selection de la vitesse.
	 */
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(this);
		vueGenerale.setGuichetCourant(null);
		vueGenerale.setTobogganCourant(null);
		vueGenerale.getBandeauVitesseChariot().setNumChariot(
				this.chariot.getId());
		vueGenerale.getBandeauVitesseChariot().setVitesseChariot(
				this.chariot.getVitesse());
		vueGenerale.getBandeauVitesseChariot().setVisible(true);
		if (Aeroport.getMode() == Mode.MANUEL) {
			vueGenerale
					.getZoneInfo()
					.setText(
							"Veuillez selectionner la destination suivante du chariot.");
		}
	}

	/**
	 * Calcule l'angle d'affichage du chariot en fonction de son prochain noeud.
	 */
	private void calculerAngleTour() {
		Noeud prochainNoeud = chariot.getProchainNoeud();
		if (prochainNoeud != null) {
			int xAux = (int) Math.round(prochainNoeud.getCoordonnees().x
					* vueGenerale.getEchelle() - imageWidth / 2);
			int yAux = (int) Math.round(prochainNoeud.getCoordonnees().y
					* vueGenerale.getEchelle() - imageHeight / 2);
			Point prochain = new Point(xAux, yAux);
			double h = prochain.y - posPixel.y;
			double b = prochain.x - posPixel.x;
			alpha = Math.atan2(h, b);
		}

	}

	public Chariot getChariot() {
		return chariot;
	}

}
