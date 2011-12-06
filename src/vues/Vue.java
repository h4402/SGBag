package vues;

import java.awt.Rectangle;

public abstract class Vue {
	
	protected VueAeroport vueAeroport; //En fait VueAeroport n'est pas une vue (changer de nom ?)
	protected int hauteur;
	protected int largeur;
	protected int alpha;
	protected Rectangle rectangle;
	protected boolean selection;
	
	boolean dansRectangle(int x, int y){
		//TODO: Défini si le point en pixel, passé en parametre se situe dans le rectangle L,H alpha
		return true;
	}
	
	void selectionner(){
		selection = true;
	}
	
	void deselectionner(){
		selection = false;
	}
	
	abstract void clic(int x, int y);
	abstract void dessin();
	abstract void action(); //Effectue l'action consÃ©cutive au clic sur l'objet
	
	

}
