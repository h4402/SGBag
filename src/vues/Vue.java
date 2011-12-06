package vues;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Vue {
	
	protected VueAeroport vueAeroport; //En fait VueAeroport n'est pas une vue (changer de nom ?)
	protected Rectangle rectangle;
	protected Point posPixel;
	protected boolean selection;
	
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
