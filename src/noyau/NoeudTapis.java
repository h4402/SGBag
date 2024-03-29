package noyau;

import java.awt.Point;
import java.util.List;

/**
 * Noeud spécialement adapté à la mise en place des bagages.
 * 
 * @author H4402
 */
public class NoeudTapis extends Noeud {
	
	/**
	 * Tapis associé au noeud.
	 */
	private Tapis tapis;
	
	/**
	 * Le chariot qui attente un bagage à ce noeud.
	 */
	private Chariot chariotVide;

	/**
	 * Constructeur pratique pour GreenUML.
	 * 
	 * @param id Id du noeud.
	 * @param listRailsSortie Liste des rails de sortie.
	 * @param coordonnees Coordonnées du noeud.
	 * @param chariotVide Chariot Vide de départ.
	 * @param tapis Tapis associé au noeud.
	 * @param chariotVide Si un chariot attend un bagage à ce noeud.
	 */
	public NoeudTapis(int id, List<Rail> listRailsSortie, Point coordonnees, Tapis tapis, Chariot chariotVide) {
		super(id, coordonnees);
		this.tapis = tapis;
		this.chariotVide = chariotVide;
	}
	
	
	/**
	 * Constructeur pour le XML.
	 * Le tapis n'est pas donné à cause de la double inclusion
	 * (le tapis doit connaitre le noeud).
	 * 
	 * @param id Id du noeud.
	 * @param coordonnees Coordonnées du noeud.
	 */
	public NoeudTapis(int id, Point coordonnees) {
		super(id, coordonnees);
		this.tapis = null;
		this.chariotVide = null;
	}
	
	/**
	 * Constructeur pour le XML.
	 * Le tapis n'est pas donné à cause de la double inclusion
	 * (le tapis doit connaitre le noeud).
	 * 
	 * @param id Id du noeud.
	 * @param coordonnees Coordonnées du noeud.
	 * @param listRailSortie Liste des rails en sortie du noeud.
	 */
	public NoeudTapis(int id, Point coordonnees, List<Rail> listRailSortie) {
		super(id, listRailSortie, coordonnees);
		this.tapis = null;
		this.chariotVide = null;
	}
	
	/**
	 * Ajoute un tapis au noeudTapis.
	 * 
	 * @param t Tapis associé au noeud.
	 */
	public void setTapis(Tapis t) {
		this.tapis = t;
	}

	/**
	 * Averti que le chariot est arrivé.
	 * 
	 * @param c Chariot à remplir.
	 */
	public void avertirChariotPresent(Chariot c) {
		chariotVide = c;
	}
	
	/**
	 * On a mis un bagage dans le chariot.
	 */
	public void avertirChariotPlein() {
		chariotVide = null;
	}

	/**
	 * Retourne le chariot Vide du noeud si il est présent.
	 * 
	 * @return Le chariot si présent, null sinon.
	 */
	public Chariot getChariotVide() {
		return chariotVide;
	}

}
