package noyau;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;

/**
 * Toboggan permettant la fin de transfert des bagages.
 * 
 * @author H4402
 */
public class Toboggan extends ES {
	/**
	 * Identifiant d'un rail
	 */
	protected int id;
	
	/**
	 * Liste des bagages bien acheminés.
	 * 
	 * @uml.property  name="listBagages"
	 */
	private List<Bagage> listBagages;
	
	/**
	 * Constructeur du Toboggan utile à GreenUML.
	 * 
	 * @param noeud Noeud associé à l'ES.
	 * @param listBagages Liste des bagages acheminés.
	 * @param coordonnees Coordonnées de l'ES.
	 */
	public Toboggan(Noeud noeud, List<Bagage> listBagages) {
		super(noeud);
		this.listBagages = listBagages;
	}
	
	/**
	 * Constructeur par défault, sans noeud.
	 */
	public Toboggan() {
		super(null);
		this.listBagages = new LinkedList<Bagage>();
	}
	
	/**
	 * Ajouter un bagage à la liste des bagages terminés.
	 * 
	 * @param b Le bagage à ajouter.
	 */
	public void ajouterBagage(Bagage b) {
		listBagages.add(b);
	}

	public Point getCoordonnees(){
		return noeud.getCoordonnees();
	}
	
	/**
	 * Permet de compléter un objet vide à partir du XML
	 * 
	 * @param tobogganElement Element XML Toboggan
	 * @param aeroport Aeroport
	 * @return Résultat du parsing
	 */
	public int construireAPartirDeXML(Element tobogganElement, Aeroport aeroport)
	{
        // On récupère l'id
		this.id = Integer.parseInt(tobogganElement.getAttribute("id"));
		
		// On récupère le noeud associé
        int idNoeud = Integer.parseInt(tobogganElement.getAttribute("idNoeud"));
        
        this.noeud = new NoeudToboggan(idNoeud, aeroport.getNoeud(idNoeud).getCoordonnees(),
        		this, aeroport.getNoeud(idNoeud).getListeRails());
        
        aeroport.getListeNoeuds().remove(aeroport.getNoeud(idNoeud));
		aeroport.ajouterNoeud(this.noeud);
        
        return Aeroport.PARSE_OK;
    }
}
