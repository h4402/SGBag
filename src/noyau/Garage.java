package noyau;

import java.util.Iterator;
import java.util.LinkedList;

import org.w3c.dom.Element;

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
	 * Liste des tapis qui ont appelé un chariot
	 * quand le garage était vide.
	 */
	private LinkedList<Noeud> listTapisARejoindre;

	/**
	 * Constructeur pratique pour GreenUML.
	 * 
	 * @param noeud Noeud de l'ES.
	 * @param listChariotsVides Liste des chariots vides.
	 * @param listChariotsPourPartir Liste des chariots en attente.
	 * @param coordonnees Coordonnées de l'ES.
	 * @param listTapisARejoindre Liste des tapis a rejoindre.
	 */
	public Garage(Noeud noeud, LinkedList<Chariot> listChariotsVides,
			LinkedList<Chariot> listChariotsPourPartir,
			LinkedList<Noeud> listTapisARejoindre) {
		super(noeud);
		this.listChariotsVides = listChariotsVides;
		this.listChariotsPourPartir = listChariotsPourPartir;
		this.listTapisARejoindre = listTapisARejoindre;
	}
	
	/**
	 * Constructeur par défault.
	 */
	public Garage() {
		super();
		this.listChariotsVides = new LinkedList<Chariot>();
		this.listChariotsPourPartir = new LinkedList<Chariot>();
		this.listTapisARejoindre = new LinkedList<Noeud>();
	}
	
	/**
	 * Ajoute un chariot vide dans le garage.
	 * 
	 * @param c Chariot vide.
	 */
	public void ajouterChariotVide(Chariot c) {
		if(!listTapisARejoindre.isEmpty() && Aeroport.mode == Aeroport.Mode.AUTO) {
			listChariotsVides.offerLast(c);
			appelerChariot(listTapisARejoindre.poll());
		}
		else {
			c.calculerChemin(null, null);
			c.majPos(null,null,0);
			listChariotsVides.offerLast(c);
		}
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
				c.suppProchainRail();
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
		if(c != null) {
			c.calculerChemin(this.getNoeud(), n);
			
			Rail r = c.getProchainRail(this.getNoeud());
			
			if(!r.ajoutChariot(c)) {
				listChariotsPourPartir.offerLast(c);
			}
			else {
				c.suppProchainRail();
			}
		}
		else {
			listTapisARejoindre.offerLast(n);
		}
	}
	

	public int construireAPartirDeXML(Element chariotElement, Aeroport aeroport)
	{
		int idNoeudGarage = Integer.parseInt(chariotElement.getAttribute("noeudParDefaut"));
		
		// Instanciation  du noeud garage
		NoeudGarage noeudGarage = new NoeudGarage(idNoeudGarage, aeroport.getNoeud(idNoeudGarage).getCoordonnees(), this);
		Aeroport.garage.setNoeud(noeudGarage);
		
		aeroport.getListeNoeuds().remove(aeroport.getNoeud(idNoeudGarage));
		aeroport.ajouterNoeud(noeudGarage);
		
		return Aeroport.PARSE_OK;
	}
	
	
	public LinkedList<Chariot> getListChariotsVides() {
		return listChariotsVides;
	}

	public LinkedList<Chariot> getListChariotsPourPartir() {
		return listChariotsPourPartir;
	}

}
