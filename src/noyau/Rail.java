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
	private int id;
	
	/**
	 * Distance de sécurité entre deux chariots
	 */
	public static final int distSecu = 2; 
	
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
		Chariot prev = null;
		while ( it.hasNext() ) {
		    Chariot c = it.next();
		    
			float distChariot = c.calculerNouvPos();

			/* 
			 * Si il n'y a pas de chariot précédent, ou si on ne le dépasse pas.
			 */
			if(prev == null || distChariot < prev.getDistance()) {
				c.setArret(false);
				/*
				 * Si le chariot est toujours dans le rail,
				 * on l'avance.
				 */
				if(distChariot < longueur) {
					c.majPos(noeudEntree, getVectUnitaire(), distChariot);
				}
				else {
					
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
					 * Si on est la, le chariot continue son chemin,
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
					else {
						c.setArret(true);
					}
				}
			}
			else {
				/*
				 * Si on est la, c'est qu'on peut dépasser un chariot
				 * On met alors notre chariot le plus près possible du précédent.
				 */
				c.majPos(noeudEntree, getVectUnitaire(), prev.getDistance()-distSecu);
			}
			
			prev = c;
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
		 * Si il n'y a pas de bagage qui vient d'arriver sur le rail,
		 * je l'ajoute.
		 */
		if(listChariots.getLast().getDistance() > 0) {
			c.majPos(noeudEntree, getVectUnitaire(), 0);
			return true;
		}
		else {
			return false;
		}
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
	 * Retourne la longueur du rail.
	 * 
	 * @return Longueur du rail.
	 */
	public float getLongueur() {
		return longueur;
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
		
		aeroport.ajouterRail(this);
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
		Rail other = (Rail) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

