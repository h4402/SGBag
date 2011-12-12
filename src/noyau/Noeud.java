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
public class Noeud implements Comparable {
	
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
        // On recupere l'id et les coordonnees
		this.id = Integer.parseInt(noeudElement.getAttribute("id"));
        this.coordonnees.move(Integer.parseInt(noeudElement.getAttribute("posX")),
        		Integer.parseInt(noeudElement.getAttribute("posY")));
        
        return Aeroport.PARSE_OK;
    }
	
	/**
	 * Retourne l'id du noeud.
	 * 
	 * @return Id du noeud.
	 */
	public int getId() {
		return id;
	}
	
	// TODO : ajouter une methode ajouterRail
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Noeud other = (Noeud) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		if (this == arg0)
			return 0;
		if (arg0 == null)
			return 1;
		Noeud other = (Noeud)arg0;
		if (id == other.id)
			return 0;
		else if (id > other.id)
			return 1;
		else
			return -1;
	}
}
