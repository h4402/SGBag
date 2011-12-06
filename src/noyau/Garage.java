package noyau;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Objet dans lequel sera rangé tous les chariots
 * vides et les chariots en attente de partir
 * pour chercher un bagage.
 * 
 * @author H4402
 */
public class Garage extends ES {

	/**
	 * Liste des chariots vides.
	 * Gérée en FIFO.
	 * 
	 * @uml.property  name="listChariotsVides"
	 */
	private LinkedList<Chariot> listChariotsVides;
	
	/**
	 * Liste des chariots vides qui doivent
	 * aller récupérer un bagage.
	 * Gérée en FIFO.
	 * 
	 * @uml.property  name="listChariotsPourPartir"
	 */
	private LinkedList<Chariot> listChariotsPourPartir;

	/**
	 * Constructeur pratique pour GreenUML.
	 * 
	 * @param noeud Noeud de l'ES.
	 * @param listChariotsVides Liste des chariots vides.
	 * @param listChariotsPourPartir Liste des chariots en attente.
	 * @param coordonnees Coordonnées de l'ES.
	 */
	public Garage(Noeud noeud, LinkedList<Chariot> listChariotsVides,
			LinkedList<Chariot> listChariotsPourPartir, Point coordonnees) {
		super(noeud, coordonnees);
		this.listChariotsVides = listChariotsVides;
		this.listChariotsPourPartir = listChariotsPourPartir;
	}
	
	/**
	 * Ajoute un chariot vide dans le garage.
	 * 
	 * @param c Chariot vide.
	 */
	public void ajouterChariotVide(Chariot c) {
		c.calculerChemin(null, null);
		c.majPos(this.getNoeud().getCoordoonees());
		listChariotsVides.offerLast(c);
	}

	/**
	 * Essais de mettre sur rail les bagages 
	 * en attente.
	 */
	public void faireSortirAttente() {
		Iterator<Chariot> it = listChariotsPourPartir.iterator(); 
		while(it.hasNext()) {
			Chariot c = it.next();
			Rail r = c.getProchainRail(this.getNoeud());
			if(r.ajoutChariot(c)) {
				it.remove();
			}
		} 
	}

	/**
	 * Envoi un chariot vers un Tapis
	 * pour prendre un bagage.
	 * Si echec, le met en attente pour le 
	 * prochain top.
	 * 
	 * @param n Le noeud vers lequel envoyé.
	 */
	public void appelerChariot(Noeud n) {
		Chariot c = listChariotsVides.poll();
		
		c.calculerChemin(this.getNoeud(), n);
		Rail r = c.getProchainRail(n);
		if(!r.ajoutChariot(c)) {
			listChariotsPourPartir.offerLast(c);
		}
	}

}
