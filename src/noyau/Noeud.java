package noyau;

import java.awt.Point;
import java.util.List;

/**
 * Un Noeud correspond au noeud d'un graphe.
 * Un noeud possède des coordonnées, et connait 
 * les rails auquel il mène.
 * 
 * @author H4402
 */
public class Noeud {
	
	/**
	 * Liste des rails auquels mènent le noeud.
	 * 
	 * @uml.property  name="listRailsSortie"
	 */
	protected List<Rail> listRailsSortie;
	
	/**
	 * Coordonnées physiques du point.
	 * 
	 * @uml.property  name="coordonnees"
	 */
	protected Point coordonnees;
	
	/**
	 * Constructeur utile pour GreenUML.
	 * 
	 * @param listRailsSortie Liste des rails de sortie.
	 * @param coordonnees Coordonnées du noeud.
	 */
	public Noeud(List<Rail> listRailsSortie, Point coordonnees) {
		super();
		this.listRailsSortie = listRailsSortie;
		this.coordonnees = coordonnees;
	}
	
	/**
	 * Retourne la liste des rails auquels mène le noeud.
	 * 
	 * @return Liste des rails en sortie du noeud.
	 */
	public List<Rail> getListeRails() {
		return listRailsSortie;
	}
	
	/**
	 * Retourne les coordonnées du noeud.
	 * 
	 * @return Coordonnées du noeud.
	 */
	public Point getCoordoonees() {
		return coordonnees;
	}

}
