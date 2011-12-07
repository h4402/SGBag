package noyau;

import java.awt.Point;
import java.util.LinkedList;

import org.w3c.dom.Element;
import java.lang.Object;

/**
 * Objet représentant un guichet,
 * par lequel on va ajouter des bagages 
 * à l'aéroport.
 * 
 * @author H4402
 */
public class Guichet {
	/**
	 * Identifiant d'un guichet
	 */
	protected int id;
	
	/**
	 * Tapis sur lequel le guichet dépose les bagages.
	 * 
	 * @uml.property  name="tapis"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Tapis tapis;
	
	/**
	 * Coordonnées du Guichet.
	 */
	private Point coordonnees;
	
	/**
	 * Liste des bagages qu'on ne peut 
	 * mettre sur le tapis (on peut considéré
	 * que c'est une file de voyageur).
	 * Gérée en FIFO.
	 * 
	 * @uml.property  name="listBagages"
	 */
	private LinkedList<Bagage> listBagages;

	/**
	 * Constructeur pour GreenUML.
	 * 
	 * @param tapis Tapis sur lequel on dépose les bagages.
	 * @param listBagages Liste des bagages en attente d'etre déposés.
	 * @param coordonnees Coordonnées du guichet.
	 */
	public Guichet(Tapis tapis, LinkedList<Bagage> listBagages,
		Point coordonnees) {
		super();
		this.tapis = tapis;
		this.listBagages = listBagages;
		this.coordonnees = coordonnees;
	}

	/**
	 * Ajout de bagages dans le guichet.
	 * Si la file de voyageur est vide,
	 * on ajoute directement celui-la,
	 * sinon, on ajoute celui en tete de file
	 * et on ajoute le bagage de parametre en fin de file.
	 */
	public void ajoutBagage(Bagage b) {
		Bagage bPrio = listBagages.poll();
		if(bPrio == null) {
			if(b != null) {
				if(!tapis.ajouterBagage(b)) {
					listBagages.add(b);
				}
			}
		}
		else {
			if(!tapis.ajouterBagage(bPrio)) {
				listBagages.add(bPrio);
				if(b != null) {
					listBagages.offerLast(b);
				}
			}
		}
		
	}
	
	/**
	 * Retourne les coordonnées du Guichet
	 * 
	 * @return Coordonnées du guichet.
	 */
	public Point getCoordoonees() {
		return coordonnees;
	}

	/**
	 * Permet de compléter un objet vide à partir du XML
	 * 
	 * @param guichetElement Element XML Guichet
	 * @param aeroport Aeroport
	 * @return Résultat du parsing
	 */
	public int construireAPartirDeXML(Element guichetElement, Aeroport aeroport)
	{
        // On récupère l'id et les coordonnées
		this.id = Integer.parseInt(guichetElement.getAttribute("id"));
		int posX = Integer.parseInt(guichetElement.getAttribute("posX"));
        int posY = Integer.parseInt(guichetElement.getAttribute("posY"));
        this.coordonnees = new Point(posX, posY);
        
        LinkedList<Bagage> liste = new LinkedList<Bagage>();
        this.listBagages = liste;
        
        // On récupère le noeud associé
        int idNoeud = Integer.parseInt(guichetElement.getAttribute("idNoeud"));
        Noeud noeudTapis = aeroport.getNoeud(idNoeud);
        this.tapis.setNoeud(noeudTapis);

        int longueurTapis = (int) Math.sqrt(Math.pow((noeudTapis.getCoordoonees().getX() - posX),2)
        		+ Math.pow((noeudTapis.getCoordoonees().getY() - posY),2));
        int nbBagages = Math.round(longueurTapis/Bagage.TAILLE_BAGAGE);
        Tapis tapis = new Tapis(aeroport.getNoeud(idNoeud), new Bagage[nbBagages] , 0, 0, longueurTapis);
        aeroport.ajouterTapis(tapis);
        
        return Aeroport.PARSE_OK;
    }
}
