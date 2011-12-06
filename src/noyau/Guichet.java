package noyau;

import java.util.LinkedList;

/**
 * Objet représentant un guichet,
 * par lequel on va ajouter des bagages 
 * à l'aéroport.
 * 
 * @author H4402
 */
public class Guichet {

	/**
	 * Tapis sur lequel le guichet dépose les bagages.
	 * 
	 * @uml.property  name="tapis"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Tapis tapis;
	
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
	 */
	public Guichet(Tapis tapis, LinkedList<Bagage> listBagages) {
		super();
		this.tapis = tapis;
		this.listBagages = listBagages;
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

}
