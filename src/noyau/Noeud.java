package noyau;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

/**
 * Un Noeud correspond au noeud d'un graphe.
 * Un noeud possède des coordonnées, et connait 
 * les rails auquel il mène.
 * 
 * @author H4402
 */
public class Noeud {
	/**
	 * Identifiant d'un noeud
	 */
	protected int id;
	
	/**
	 * Liste des rails auquels mènent le noeud.
	 * 
	 * @uml.property  name="listRailsSortie"
	 */
	protected List<Rail> listRailsSortie;
	
	/**
	 * Permet d'ajouter un rail de sortie au noeud
	 * 
	 * @param rail Rail
	 */
	public void ajouterRailDeSortie(Rail rail)
	{
		this.listRailsSortie.add(rail);
	}
	
	/**
	 * Coordonnées physiques du point.
	 * 
	 * @uml.property  name="coordonnees"
	 */
	protected Point coordonnees;
	
	/**
	 * Constructeur utile pour GreenUML.
	 * 
	 * @param id Id du noeud.
	 * @param listRailsSortie Liste des rails de sortie.
	 * @param coordonnees Coordonnées du noeud.
	 */
	public Noeud(int id, List<Rail> listRailsSortie, Point coordonnees) {
		this.id = id;
		this.listRailsSortie = listRailsSortie;
		this.coordonnees = coordonnees;
	}
	
	/**
	 * Constructeur utile pour les Tests.
	 * 
	 * @param id Id du noeud.
	 * @param coordonnees
	 */
	public Noeud(int id, Point coordonnees) {
		this.id = id;
		this.coordonnees = coordonnees;
		this.listRailsSortie = new ArrayList<Rail>();
	}
	
	/**
	 * Constructeur par défault.
	 */
	public Noeud() {
		this.coordonnees = new Point();
		this.listRailsSortie = new ArrayList<Rail>();
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
	public Point getCoordonnees() {
		return coordonnees;
	}
	
	/**
	 * Permet de compléter un objet vide à partir du XML
	 * 
	 * @param noeudElement Element XML Noeud
	 * @param aeroport Aeroport
	 * @return Résultat du parsing
	 */
	public int construireAPartirDeXML(Element noeudElement)
	{
        // On récupère l'id et les coordonnées
		this.id = Integer.parseInt(noeudElement.getAttribute("id"));
        this.coordonnees.move(Integer.parseInt(noeudElement.getAttribute("posX")),
        		Integer.parseInt(noeudElement.getAttribute("posY")));
        
        return Aeroport.PARSE_OK;
    }
	
	// TODO : ajouter une methode ajouterRail
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noeud other = (Noeud) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
