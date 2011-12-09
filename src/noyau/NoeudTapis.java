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
	 * Averti que le chariot est arrivé.
	 * 
	 * @param c Chariot à remplir.
	 */
	public void avertirChariotPresent(Chariot c) {
		chariotVide = c;
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
