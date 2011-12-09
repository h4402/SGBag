package noyau;

import java.awt.Point;
import java.util.List;

/**
 * Noeud spécialisé dans la connexion d'un toboggan.
 * 
 * @author H4402
 */
public class NoeudToboggan extends Noeud {

	/**
	 * Toboggan associé au noeud.
	 * 
	 * @uml.property  name="sortie"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Toboggan sortie;

	/**
	 * Noeud obligatoire pour GreenUML.
	 * 
	 * @param id Id du noeud.
	 * @param listRailsSortie Liste des rails de sortie du noeud.
	 * @param coordonnees Coordonnées du noeud.
	 * @param sortie Toboggan associé à ce noeud.
	 */
	public NoeudToboggan(int id, List<Rail> listRailsSortie, Point coordonnees,
			Toboggan sortie) {
		super(id, listRailsSortie, coordonnees);
		this.sortie = sortie;
	}

	/**
	 * Constructeur simple pour le XML.
	 * 
	 * @param id ID du noeud.
	 * @param coordonnees Coordonnées du noeud.
	 * @param sortie Toboggan du noeud.
	 */
	public NoeudToboggan(int id, Point coordonnees, Toboggan sortie) {
		super(id, coordonnees);
		this.sortie = sortie;
	}
	
	/**
	 * Retourne le toboggan associé à ce noeud.
	 * 
	 * @return Le toboggan associé au noeud.
	 */
	public Toboggan getToboggan() {
		return sortie;
	}

}
