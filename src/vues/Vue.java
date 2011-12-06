package vues;

public abstract class Vue {
	
	protected VueAeroport vueAeroport; //En fait VueAeroport n'est pas une vue (changer de nom ?)
	protected int hauteur;
	protected int largeur;
	protected int alpha;
	protected boolean selection;
	
	//A faire ici partiellement puis rappel dans les heritiers ou totalement abstract?
	boolean clic(int x, int y){
		//TODO: How to detect a clic
		return true;
	}
	
	void selectionner(){
		selection = true;
	}
	
	void deselectionner(){
		selection = false;
	}
	
	abstract void dessin();
	abstract void action(); //Effectue l'action consécutive au clic sur l'objet
	
	

}
