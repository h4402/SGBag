package noyau;

import java.awt.Point;

/**
 * Classe abstraite qui définit la "forme"
 * de tous les objets par lesquels vont entrer ou sortir des
 * bagages et des chariots.
 * 
 * @author H4402
 */
public abstract class ES {

	/**
	 * Noeud associé à l'ES.
	 * 
	 * @uml.property  name="noeud"
	 * @uml.associationEnd  readOnly="true"
	 */
	protected Noeud noeud;
	
	/**
	 * Coordonnées de l'ES.
	 */
	protected Point coordonnees;

	/**
	 * Constructeur utile à GreenUML.
	 * 
	 * @param noeud Noeud associé à l'ES.
	 * @param coordonnees Coordonnées de l'ES.
	 */
	protected ES(Noeud noeud, Point coordonnees) {
		super();
		this.noeud = noeud;
		this.coordonnees = coordonnees;
	}
	
	/**
	 * Retourne le noeud associé à l'ES.
	 * 
	 * @return Noeud de l'ES.
	 */
	public Noeud getNoeud() {
		return noeud;
	}
	
	/**
	 * Retourne les coordonnées de l'ES.
	 * 
	 * @return Coordonnées de l'ES.
	 */
	public Point getCoordonnees() {
		return coordonnees;
	}
	
}
