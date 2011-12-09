package vues;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;


public abstract class Vue {
	
	protected VueGenerale vueGenerale; //name changed
	protected Shape rectangle;
	protected Image image;
	protected Image imageSel;
	protected int imageWidth;
	protected int imageHeight;
	protected Point posPixel;
	protected boolean selection;
	
	/**
	 * Constructeur pr�sent uniquement pour des raisons de factorisation du code.
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
	 * Passe la vue en mode selection�
	 */
	void selectionner(){
		selection = true;
	}
	
	/**
	 * Passe la vue en mod d�selection�
	 */
	void deselectionner(){
		selection = false;
	}
	
	/**
	 * D�tecte si un clic de souris est effectu� sur la vue
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
	 * Action cons�cutive au clic, est toujour appell�e sur l'objet qui
	 * a �t� cliqu�.
	 */
	abstract void action(); //Effectue l'action consécutive au clic sur l'objet
	
	

}
