package noyau;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

import org.w3c.dom.Element;

/**
 * Classe représentant un rail dans l'application.
 * Un rail possèdent des chariots
 * qui roulent dessus, un noeud d'entrée
 * et un noeud de sortie.
 * 
 * @author H4402
 */
public class Rail {
	/**
	 * Identifiant d'un rail
	 */
	protected int id;
	
	/**
	 * Liste des chariots roulant actuellement
	 * sur le rail, où étant bloqué.
	 * Cette liste est gérée en FIFO.
	 * 
	 * @uml.property  name="listChariots"
	 */
	private LinkedList<Chariot> listChariots;
	
	/**
	 * Noeud d'entrée du rail.
	 * 
	 * @uml.property  name="noeudEntree"
	 */
	private Noeud noeudEntree;
	
	/**
	 * Noeud de sortie du rail.
	 * 
	 * @uml.property  name="noeudSortie"
	 */
	private Noeud noeudSortie;
	
	/**
	 * Direction du vecteur Rail.
	 */
	private Point direction;
	
	/**
	 * Taille du rail.
	 */
	private float longueur;

	/**
	 * Constructeur pratique pour GreenUML.
	 * 
	 * @param listChariots Liste des chariots roulants
	 * @param noeudEntree Noeud d'entrée du rail.
	 * @param noeudSortie Noeud de sortie du rail.
	 */
	public Rail(LinkedList<Chariot> listChariots, Noeud noeudEntree, Noeud noeudSortie) {
		super();
		this.listChariots = listChariots;
		this.noeudEntree = noeudEntree;
		this.noeudSortie = noeudSortie;
		direction = new Point(noeudSortie.getCoordoonees().x - noeudEntree.getCoordoonees().x,
				noeudSortie.getCoordoonees().y - noeudEntree.getCoordoonees().y);
		longueur = (float) Math.sqrt(direction.x*direction.x + direction.y*direction.y);
	}

	/**
	 * Avancer les chariots du rail lors d'un top horloge.
	 */
	public void avancerChariots() {
		Iterator<Chariot> it = listChariots.iterator();
		while ( it.hasNext() ) {
		    Chariot c = it.next();
		    
			/*
			 * TODO Envoyer la direction du rail... 
			 */
			Point p = c.calculerNouvPos(getVectUnitaire());
			
			/*
			 * TODO Vérifier que p depasse le chariot précédent.
			 * On il faut faire un calcul avec le sens et la direction
			 * du vecteur de rail, et les deux points.
			 */
			{
				/*
				 * TODO Vérifier que p est toujours dans le rail.
				 */
				{
					c.majPos(p);
				}
				/*
				 * TODO Si p est sorti du rail 
				 */
				{
					
					if(noeudSortie == c.getDestination()) {
						
						if(noeudSortie instanceof NoeudGarage) {
							((NoeudGarage)noeudSortie).getGarage().ajouterChariotVide(c);
							it.remove();
							continue;
						}
						else if(noeudSortie instanceof NoeudToboggan) {
							((NoeudToboggan)noeudSortie).getToboggan().ajouterBagage((c.viderChariot()));
							c.calculerChemin(noeudSortie, Aeroport.garage.getNoeud());
						}
						else if(noeudSortie instanceof NoeudTapis) {
							((NoeudTapis)noeudSortie).avertirChariotPresent(c);
						}
						
					}
					
					/*
					 * Si on est la, le chariot continue sont chemin,
					 * on prend le prochain rail et
					 * on essai de le placer.
					 * Si on est en mode AUTO.
					 */
					if(Aeroport.mode == Aeroport.Mode.AUTO) {
						Rail r = c.getProchainRail(noeudSortie);
						if (r.ajoutChariot(c)) {
							it.remove();
						}
					}
				}
			}
		}
	}

	/**
	 * Ajoute un chariot à un rail si c'est possible,
	 * c'est à dire s'il n'y a pas de collisions.
	 * 
	 * @param c Chariot à ajouter.
	 * @return Si l'opération a réussi ou non.
	 */
	public boolean ajoutChariot(Chariot c) {
		
		/*
		 * TODO Vérifier que les coordonnées du chariot 
		 * ne dépasse pas le dernier chariot de la liste.
		 */
		return false;
	}
	
	/**
	 * Retourne le vecteur unitaire correspondant au rail.
	 * @return Vecteur unitaire du rail.
	 */
	public Point getVectUnitaire() {
		return new Point((int)(direction.x/longueur), (int)(direction.y/longueur));
	}
	
	/**
	 * Retourne le noeud de sortie d'un rail.
	 * 
	 * @return Noeud de sortie du rail.
	 */
	public Noeud getNoeudSortie() {
		return noeudSortie;
	}
	
	/**
	 * Retourne le noeud d'entrée d'un rail.
	 * 
	 * @return Noeud d'entrée du rail.
	 */
	public Noeud getNoeudEntree() {
		return noeudEntree;
	}
	
	/**
	 * Permet de compléter un objet vide à partir du XML
	 * 
	 * @param railElement Element XML Rail
	 * @param aeroport Aeroport
	 * @return Résultat du parsing
	 */
	public int construireAPartirDeXML(Element railElement, Aeroport aeroport)
	{
		//lecture des attributs
		this.id = Integer.parseInt(railElement.getAttribute("id"));
		
		int idNoeudEntree = Integer.parseInt(railElement.getAttribute("noeudEntree"));
		int idNoeudSortie = Integer.parseInt(railElement.getAttribute("noeudSortie"));
		this.noeudEntree = aeroport.getNoeud(idNoeudEntree);
		this.noeudEntree = aeroport.getNoeud(idNoeudSortie);
        
		LinkedList<Chariot> liste = new LinkedList<Chariot>();
		this.listChariots = liste;
		
		return Aeroport.PARSE_OK;
    }
}

