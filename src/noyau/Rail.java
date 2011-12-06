package noyau;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

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
			Point p = c.calculerNouvPos();
			
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
	 * Retourne le noeud de sortie d'un rail.
	 * 
	 * @return Noeud de sortie du rail.
	 */
	public Noeud getNoeudSortie() {
		return noeudSortie;
	}
	
}

