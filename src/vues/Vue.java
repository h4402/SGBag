package vues;

import ihm.ImagesManager;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;

public abstract class Vue {

	protected VueGenerale vueGenerale;
	protected Shape rectangle;
	protected ImagesManager imagesManager;
	protected int imageWidth;
	protected int imageHeight;
	protected Point posPixel;
	protected boolean selection;

	/**
	 * Constructeur present uniquement pour des raisons de factorisation du
	 * code.
	 * 
	 * @param vueGeneral
	 * @param imagesManager
	 */
	public Vue(VueGenerale vueGeneral, ImagesManager imagesManager) {
		this.vueGenerale = vueGeneral;
		this.imagesManager = imagesManager;
		this.selection = false;
	}

	/**
	 * Test l'appartenance d'un point au rectangle de position de l'objet.
	 * 
	 * @param posClic
	 * @return
	 */
	boolean dansRectangle(Point posClic) {
		return rectangle.contains(posClic);
	}

	/**
	 * Passe la vue en mode selectionee
	 */
	void selectionner() {
		selection = true;
	}

	/**
	 * Passe la vue en mod deselectionee
	 */
	void deselectionner() {
		selection = false;
	}

	public ImagesManager getImagesManager() {
		return imagesManager;
	}

	public void setImagesManager(ImagesManager imagesManager) {
		this.imagesManager = imagesManager;
	}

	/**
	 * Detecte si un clic de souris est effectue sur la vue
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	abstract boolean clic(int x, int y);

	/**
	 * Dessine l'objet sur le graphics
	 * 
	 * @param g
	 */
	abstract void dessin(Graphics g);

	/**
	 * Action consecutive au clic, est toujours appellee sur l'objet qui a ete
	 * clique
	 */
	abstract void action(); // Effectue l'action consecutive au clic sur l'objet

}
