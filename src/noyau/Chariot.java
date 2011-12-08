package noyau;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;

/**
 * Composante de l'application qui se déplace
 * d'un noeud à l'autre sur des rails et qui 
 * achemine un bagage à la fois.
 * 
 * @author H4402
 */
public class Chariot {
	/**
	 * Identifiant d'un noeud
	 */
	protected int id;
	
	/**
	 * Coordonnées actuelles du chariot sur le rail.
	 * 
	 * @uml.property  name="coordonnees"
	 */
	private Point coordonnees;

	/**
	 * Bagage à acheminer.
	 * 
	 * @uml.property  name="bagage"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Bagage bagage;
	
	/**
	 * Vitesse du chariot en metre/millisecondes.
	 * 
	 * @uml.property  name="vitesse"
	 */
	private float vitesse;
	
	/**
	 * Liste des noeud a parcourir par le chariot
	 * avant d'arriver à destination.
	 * Gérée en FIFO.
	 * 
	 * @uml.property  name="chemin"
	 */
	private LinkedList<Noeud> chemin;
	
	/**
	 * Distance sur le rail depuis le noeud d'entrée.
	 */
	private float distanceDepuisNoeudDepart;
	
	/**
	 * Constructeur nécéssaire à GreenUML.
	 * 
	 * @param coordonnees Coordonnées initiale du chariot.
	 * @param bagage Bagage du nouveau chariot.
	 * @param vitesse Vitesse initiale du chariot.
	 * @param chemin Liste des noeud avant la destination.
	 */
	public Chariot(int id, Point coordonnees, Bagage bagage, float vitesse,
			LinkedList<Noeud> chemin) {
		super();
		this.id = id;
		this.coordonnees = coordonnees;
		this.bagage = bagage;
		this.vitesse = vitesse;
		this.chemin = chemin;
		this.distanceDepuisNoeudDepart = 0;
	}	
	
	public float getVitesse() {
		return vitesse;
	}

	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}

	public int getId() {
		return id;
	}

	/**
	 * Calcul la nouvelle distance sur le meme rail
	 * après un top horloge.
	 */
	public float calculerNouvPos() {
		return (float)(distanceDepuisNoeudDepart + vitesse*Aeroport.lapsTemps);
	}
	
	/**
	 * Calcul les nouveau coordonnées en fonction
	 * d'un rail et d'une distance sur ce rail.
	 * 
	 * @param entree Noeud d'entrée du rail.
	 * @param vectUnitaire Vecteur unitaire du rail.
	 * @param nouvDist Nouvelle distance du chariot sur le rail.
	 */
	public void majPos(Noeud entree, Point vectUnitaire, float nouvDist) {
		distanceDepuisNoeudDepart = nouvDist;
		coordonnees.x = (int)(entree.getCoordoonees().x + distanceDepuisNoeudDepart*vectUnitaire.x);
		coordonnees.y = (int)(entree.getCoordoonees().y + distanceDepuisNoeudDepart*vectUnitaire.y);
	}

	/**
	 * Retourne le prochain rail dans le chemin.
	 * 
	 * @param noeudSortie Noeud duquel on doit trouver le suivant.
	 * @return Prochain rails où se rendre dans le chemin, null si aucun.
	 */
	public Rail getProchainRail(Noeud n) {

		List<Rail> l = n.getListeRails();
		
		for (Rail r : l) {
			/*
			 * On parle du meme objet ici, donc
			 * on peut faire ce test, mais la logique voudrait
			 * peut-être faire un equals.
			 * 
			 * Il faudrait peut-être commencer avec les LinkedList,
			 * afin de pouvoir récupérer le premier élément plus facilement.
			 */
			if(r.getNoeudSortie() == chemin.peek()) {
				chemin.poll();
				return r;
			}
		}
		
		return null;
	}
	
	/**
	 * Retourne le noeud de sa fin de parcours.
	 * 
	 * @return Noeud de la fin de parcours.
	 */
	public Noeud getDestination() {
		return chemin.peekLast();
	}
	
	/**
	 * Supprime et retourne le bagage du chariot.
	 * 
	 * @return L'ancien bagage du chariot.
	 */
	public Bagage viderChariot() {
		Bagage b = bagage;
		bagage = null;
		return b;
	}
	
	/**
	 * Calcul le chemin le plus court d'un point à un autre
	 * de l'aéroport. Rempli la liste des noeud du chemin.
	 * 
	 * @param depart Noeud de départ.
	 * @param arrivee Noeud d'arrivée.
	 */
	public void calculerChemin(Noeud depart, Noeud arrivee) {
		
		if(depart == null || arrivee == null) {
			chemin.clear();
		}
		else {
			/*
			 * TODO
			 *   Faire le calcul des chemins ici, 
			 *   et ajouter au fur et à mesure dans la liste des chemins.
			 *
			 1  function Dijkstra(Graph, source):
			 2      for each vertex v in Graph:            // Initializations
			 3          dist[v] := infinity ;              // Unknown distance function from source to v
			 4          previous[v] := undefined ;         // Previous node in optimal path from source
			 5      end for ;
			 6      dist[source] := 0 ;                    // Distance from source to source
			 7      Q := the set of all nodes in Graph ;   // All nodes in the graph are unoptimized - thus are in Q
			 8      while Q is not empty:                  // The main loop
			 9          u := vertex in Q with smallest distance in dist[] ;
			10          if dist[u] = infinity:
			11              break ;                        // all remaining vertices are inaccessible from source
			12          end if ;
			13          remove u from Q ;
			14          for each neighbor v of u:          // where v has not yet been removed from Q.
			15              alt := dist[u] + dist_between(u, v) ;
			16              if alt < dist[v]:              // Relax (u,v,a)
			17                  dist[v] := alt ;
			18                  previous[v] := u ;
			19                  decrease-key v in Q;       // Reorder v in the Queue
			20              end if ;
			21          end for ;
			22      end while ;
			23      return dist[] ;
			24  end Dijkstra.
			*/
			
			
		}
		
	}

	/**
	 * Mettre un bagage dans un chariot vide.
	 * 
	 * @param b Bagage à ajouter.
	 */
	public void mettreBagage(Noeud depart, Bagage b) {
		bagage = b;
		calculerChemin(depart, b.getTogobban().getNoeud());
	}
	
	/**
	 * Retourne les coordonnées du Chariot.
	 * 
	 * @return Coordonnées actuelles du chariot.
	 */
	public Point getCoordonnees() {
		return coordonnees;
	}
	
	/**
	 * Distance sur le rail depuis le noeud de départ.
	 * 
	 * @return Distance depuis le noeud de départ.
	 */
	public float getDistance() {
		return distanceDepuisNoeudDepart;
	}
	
	/**
	 * Permet de compléter un objet vide à partir du XML
	 * 
	 * @param chariotElement Element XML Chariot
	 * @param aeroport Aeroport
	 * @return Résultat du parsing
	 */
	public int construireAPartirDeXML(Element chariotElement, Aeroport aeroport)
	{
		// On récupère les coordonnées du noeud associé
        int idNoeudGarage = Integer.parseInt(chariotElement.getAttribute("noeudParDefaut"));
        this.coordonnees = aeroport.getNoeud(idNoeudGarage).getCoordoonees();
        
        // On récupère la vitesse par défaut
        this.vitesse = Integer.parseInt(chariotElement.getAttribute("vitesseParDefaut"));;
        
        LinkedList<Noeud> liste = new LinkedList<Noeud>();
        this.chemin = liste;
        aeroport.ajouterChariot(this);
        
        return Aeroport.PARSE_OK;
    }
}
