package noyau;

import java.util.List;

/**
 * Toboggan permettant la fin de transfert des bagages.
 * 
 * @author H4402
 */
public class Toboggan extends ES {

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
	 */
	public Toboggan(Noeud noeud, List<Bagage> listBagages) {
		super(noeud);
		this.listBagages = listBagages;
	}
	
	/**
	 * Ajouter un bagage à la liste des bagages terminés.
	 * 
	 * @param b Le bagage à ajouter.
	 */
	public void ajouterBagage(Bagage b) {
		listBagages.add(b);
	}

}
