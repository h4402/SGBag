package noyau;

import java.awt.Point;
import java.util.List;

/**
 * Spécialisation de noeud, qui est adapté
 * pour être attaché à un garage.
 * 
 * @author H4402
 */
public class NoeudGarage extends Noeud {

	/**
	 * Garage de sortie des chariots.
	 * 
	 * @uml.property  name="sortie"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Garage sortie;

	/**
	 * Constructeur pour GreenUML.
	 * 
	 * @param listRailsSortie Liste des rails de sortie.
	 * @param coordonnees Coordonnées du noeud.
	 * @param sortie Garage de sortie.
	 */
	public NoeudGarage(int id, List<Rail> listRailsSortie, Point coordonnees,
			Garage sortie) {
		super(id, listRailsSortie, coordonnees);
		this.sortie = sortie;
	}
	
	/**
	 * Constructeur pour XML.
	 * 
	 * @param id Id du noeud.
	 * @param coordonnees Coordonnées du point.
	 * @param sortie Garage associé.
	 */
	public NoeudGarage(int id,Point coordonnees, Garage sortie) {
		super(id, coordonnees);
		this.sortie = sortie;
	}
	
	/**
	 * Retourne la sortie associée.
	 * 
	 * @return Garage associé au noeud.
	 */
	public Garage getGarage() {
		return sortie;
	}
	
}
