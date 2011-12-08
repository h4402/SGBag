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
	
	public Noeud(Point coordonnees) {
		this.coordonnees = coordonnees;
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
	public int construireAPartirDeXML(Element noeudElement, Aeroport aeroport)
	{
        // On récupère l'id et les coordonnées
		this.id = Integer.parseInt(noeudElement.getAttribute("id"));
		int posX = Integer.parseInt(noeudElement.getAttribute("posX"));
        int posY = Integer.parseInt(noeudElement.getAttribute("posY"));
        this.coordonnees = new Point(posX, posY);
        this.listRailsSortie = new ArrayList<Rail>();
        
        //TODO : c'est juste pas possible de faire ça là, les rails n'existent pas
        // On récupère les rails de sortie du noeud
        /*List<Rail> listeRails = aeroport.getListeRails();
        for ( Rail rail : listeRails)
        {
        	if (this.id == rail.getNoeudEntree().id)
        	{
        		this.listRailsSortie.add(rail);
        	}
        }*/

        
        aeroport.ajouterNoeud(this);
        return Aeroport.PARSE_OK;
    }

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
