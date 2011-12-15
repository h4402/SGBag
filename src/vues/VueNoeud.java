package vues;

import ihm.ImagesManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Aeroport;
import noyau.Aeroport.Mode;
import noyau.Noeud;
import noyau.NoeudGarage;

public class VueNoeud extends Vue {

	/**
	 * Objet Noeud du noyau a representer
	 */
	private Noeud noeud;

	/**
	 * Taille en metre de la representation noeud Sert de base de reference
	 * pour le calcul avec l'echelle
	 */
	static private int tailleReelle = 2;

	/**
	 * Constructeur de la vueNoeud
	 * 
	 * @param vueGenerale : VueGenerale qui possede les informations sur l'etat de l'interface
	 * @param imagesManager : Gestionnaire des images utilisees pour dessiner les Vues
	 * @param noeud : Objet Noeud du noyau a representer 
	 */
	public VueNoeud(VueGenerale vueGenerale, ImagesManager imagesManager,
			Noeud noeud) {
		super(vueGenerale, imagesManager);

		this.imageWidth = (int) Math.round(tailleReelle
				* vueGenerale.getEchelle());
		this.imageHeight = (int) Math.round(tailleReelle
				* vueGenerale.getEchelle());

		this.noeud = noeud;

		posPixel = new Point((int) Math.round(this.noeud.getCoordonnees().x
				* this.vueGenerale.getEchelle() - imageWidth / 2),
				(int) Math.round(this.noeud.getCoordonnees().y
						* this.vueGenerale.getEchelle() - imageHeight / 2));

		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth,
				imageHeight);
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		return dansRectangle(p);
	}

	/**
	 * Dessine le noeud. Affiche le numero du noeud par dessus le dessin
	 */
	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (selection) {
			if (noeud instanceof NoeudGarage) { // Traitement particulier dans
												// le cas d'un NoeudGarage
				g2d.drawImage(imagesManager.getImgNodeGarageSel(), posPixel.x,
						posPixel.y, imageWidth, imageHeight, vueGenerale);
				vueGenerale.getZoneInfo().setText(
						"<html>Chariots presents : "
								+ Aeroport.garage.getListChariotsVides().size()
								+ "<br>"
								+ "Chariots en attente de depart : "
								+ Aeroport.garage.getListChariotsPourPartir()
										.size() + "</html>");
			} else {
				g2d.drawImage(imagesManager.getImgNodeSel(), posPixel.x,
						posPixel.y, imageWidth, imageHeight, vueGenerale);
			}
		} else {
			if (noeud instanceof NoeudGarage) {
				g2d.drawImage(imagesManager.getImgNodeGarage(), posPixel.x,
						posPixel.y, imageWidth, imageHeight, vueGenerale);
			} else {
				g2d.drawImage(imagesManager.getImgNode(), posPixel.x,
						posPixel.y, imageWidth, imageHeight, vueGenerale);
			}
		}
		if (noeud.getId() < 10) {
			Font f = new Font("Courier", Font.BOLD, imageWidth);
			g2d.setFont(f);
			g2d.setColor(Color.WHITE);
			g2d.drawString(Integer.toString(noeud.getId()),
					(float) (posPixel.x + imageWidth / 4),
					(float) (posPixel.y + imageHeight / 1.25));
		} else {
			Font f = new Font("Courier", Font.BOLD,
					(int) Math.round(imageWidth / 1.5));
			g2d.setFont(f);
			g2d.setColor(Color.WHITE);
			g2d.drawString(Integer.toString(noeud.getId()),
					(float) (posPixel.x + imageWidth / 6),
					(float) (posPixel.y + imageHeight / 1.5));
		}
	}

	/**
	 * Seul un NoeudGarage est selectionable
	 */
	@Override
	void action() {
		if (noeud instanceof NoeudGarage) {
			this.selectionner();
			if (Aeroport.getMode() == Mode.MANUEL) {
				vueGenerale.getBandeauSortirChariot().setVisible(true);
			}
		}

	}

	public Noeud getNoeud() {
		return noeud;
	}

}
