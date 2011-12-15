package vues;

import ihm.ImagesManager;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;

public abstract class Vue {

	/**
	 * VueGenerale qui possede les informations sur l'etat de l'interface
	 */
	protected VueGenerale vueGenerale;

	/**
	 * Rectangle de detection du clic
	 */
	protected Shape rectangle;

	/**
	 * Gestionnaire des images utilisees pour dessiner les Vues
	 */
	protected ImagesManager imagesManager;

	/**
	 * Taille de dessin de la vue en largeur
	 */
	protected int imageWidth;

	/**
	 * Taille de dessin de la vue en hauteur
	 */
	protected int imageHeight;

	/**
	 * Position de l'objet a dessiner en pixels
	 */
	protected Point posPixel;

	/**
	 * Determine si l'objet est selectionne ou non
	 */
	protected boolean selection;

	/**
	 * Constructeur present uniquement pour des raisons de factorisation du
	 * code.
	 * 
	 * @param vueGeneral
	 *            : VueGenerale qui possede les informations sur l'etat de
	 *            l'interface
	 * @param imagesManager
	 *            : Gestionnaire des images utilisees pour dessiner les Vues
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
