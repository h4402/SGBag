package vues;

import ihm.ImagesManager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import noyau.Bagage;
import noyau.Tapis;

public class VueTapis extends Vue {

	private Tapis tapis;
	private Point pointA;
	private Point pointB;
	private double alpha;

	static private double largeurReelleElem = 1.1 * Bagage.TAILLE_BAGAGE;
	static private double longueurReelleElem = Bagage.TAILLE_BAGAGE;

	/**
	 * Constructeur de la VueTapis
	 * 
	 * @param vueGeneral
	 * @param imagesManager
	 * @param tapis
	 */
	public VueTapis(VueGenerale vueGeneral, ImagesManager imagesManager,
			Tapis tapis) {
		super(vueGeneral, imagesManager);

		this.imageWidth = (int) Math.round(longueurReelleElem
				* vueGenerale.getEchelle());
		this.imageHeight = (int) Math.round(largeurReelleElem
				* vueGenerale.getEchelle());

		this.tapis = tapis;
		constructionRectangle();
	}

	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(alpha, pointA.x, pointA.y); // On tourne le graphics pour
												// dessiner le tapis avec un
												// angle alpha
		for (int i = 0; i < tapis.getListBagages().size(); i++) {
			if (tapis.getListBagages().elementAt(i) == null) {
				if (selection)
					g2d.drawImage(imagesManager.getImgTapisSel(), pointA.x + i
							* imageWidth, pointA.y - imageHeight / 2,
							imageWidth, imageHeight, vueGenerale);
				else
					g2d.drawImage(imagesManager.getImgTapis(), pointA.x + i
							* imageWidth, pointA.y - imageHeight / 2,
							imageWidth, imageHeight, vueGenerale);
			} else {
				if (selection)
					g2d.drawImage(imagesManager.getImgTapisBSel(), pointA.x + i
							* imageWidth, pointA.y - imageHeight / 2,
							imageWidth, imageHeight, vueGenerale);
				else
					g2d.drawImage(imagesManager.getImgTapisB(), pointA.x + i
							* imageWidth, pointA.y - imageHeight / 2,
							imageWidth, imageHeight, vueGenerale);
			}
		}
		g2d.rotate(-alpha, pointA.x, pointA.y); // On tourne le graphics de
												// -alpha pour remettre le
												// dessin droit
	}

	@Override
	void action() {
		this.selectionner();
	}

	@Override
	boolean clic(int x, int y) {
		return false;
	}

	/**
	 * Construit le rectangle permettant la detection de clic
	 */
	private void constructionRectangle() {
		pointA = new Point(tapis.getGuichet().getCoordonnees());
		pointB = new Point(tapis.getNoeud().getCoordonnees());
		pointA.x = (int) Math.round(pointA.getX() * vueGenerale.getEchelle());
		pointA.y = (int) Math.round(pointA.getY() * vueGenerale.getEchelle());
		pointB.x = (int) Math.round(pointB.getX() * vueGenerale.getEchelle());
		pointB.y = (int) Math.round(pointB.getY() * vueGenerale.getEchelle());

		double h = pointB.y - pointA.y;
		double b = pointB.x - pointA.x;
		alpha = Math.atan2(h, b);

		rectangle = new Rectangle((int) Math.round(pointA.x),
				(int) Math.round(pointA.y - imageHeight / 2),
				(int) Math.round(pointA.distance(pointB)), imageHeight);
		AffineTransform rotation = AffineTransform.getRotateInstance(alpha,
				pointA.x, pointA.y);
		rectangle = rotation.createTransformedShape(rectangle);

	}

}
