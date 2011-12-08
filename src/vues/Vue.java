package vues;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Vue {
	
	protected VueGenerale vueGenerale; //name changed
	protected Rectangle rectangle;
	protected Image image;
	protected Image imageSel;
	protected int imageWidth;
	protected int imageHeight;
	protected Point posPixel;
	protected boolean selection;
	
	/**
	 * Constructeur présent uniquement pour des raisons de factorisation du code.
	 * @param vueGeneral
	 * @param image
	 */
	public Vue(VueGenerale vueGeneral, Image image, Image imageSel){
		this.vueGenerale = vueGeneral;
		this.image = image;
		this.imageSel = imageSel;
		this.imageWidth = (int)Math.round(vueGeneral.getCoefImage());
		this.imageHeight = (int)Math.round(vueGeneral.getCoefImage()*this.image.getHeight(vueGeneral)/this.image.getWidth(vueGeneral)/2);
		this.selection = false;
	}
	
	/**
	 * Test l'appartenance d'un point au rectangle de position de l'objet. 
	 * @param posClic
	 * @return
	 */
	boolean dansRectangle(Point posClic){
		return rectangle.contains(posClic);
	}
	
	/**
	 * Passe la vue en mode selectioné
	 */
	void selectionner(){
		selection = true;
	}
	
	/**
	 * Passe la vue en mod déselectioné
	 */
	void deselectionner(){
		selection = false;
	}
	
	/**
	 * Détecte si un clic de souris est effectué sur la vue
	 * @param x
	 * @param y
	 * @return
	 */
	abstract boolean clic(int x, int y);
	
	/**
	 * Dessine l'objet sur le graphics
	 * @param g
	 */
	abstract void dessin(Graphics g);
	
	/**
	 * Action consécutive au clic, est toujour appellée sur l'objet qui
	 * a été cliqué.
	 */
	abstract void action(); //Effectue l'action consÃ©cutive au clic sur l'objet
	
	

}
