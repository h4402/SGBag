package vues;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class Vue {
	
	protected VueGenerale vueGenerale; //name changed
	protected Rectangle rectangle;
	protected Image image;
	protected Point posPixel;
	protected boolean selection;
	
	public Vue(VueGenerale vueGeneral, Image image){
		this.vueGenerale = vueGeneral;
		this.image = image;
	}
	boolean dansRectangle(Point posClic){
		return rectangle.contains(posClic);
	}
	
	void selectionner(){
		selection = true;
	}
	
	void deselectionner(){
		selection = false;
	}
	
	abstract boolean clic(int x, int y);
	abstract void dessin();
	abstract void action(); //Effectue l'action consécutive au clic sur l'objet
	
	

}
