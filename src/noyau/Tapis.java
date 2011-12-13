package noyau;

import java.util.Vector;

/**
 * Un tapis est une file de bagage
 * qui arrive d'un guichet
 * et attendent d'être pris en charge par
 * un chariot.
 * 
 * @author H4402
 */
public class Tapis extends ES {
	
	/**
	 * Taille d'un tapis définie par le systeme.
	 */
	private int tailleTapis;
	
	/**
	 * File de bagage.
	 * Gérée en FIFO.
	 * 
	 * @uml.property  name="listBagages"
	 */
	private Vector<Bagage> listBagages;
	
	/**
	 * Vitesse en nombre de top quand faire avancer un bagage.
	 * exemple: 
	 * 	1: On fait avancer un bagage par top horloge.
	 *  2: On fait avancer un bagage pour deux top horloges. 
	 */
	public static int vitesse;
	
	/**
	 * Compte le nombre de top passé en rapport à la vitesse;
	 */
	private int topCourant;
	
	/**
	 * Guichet associé au rail.
	 */
	private Guichet guichet;

	/**
	 * Constructeur pratique pour GreenUML.
	 * 
	 * @param noeud Noeud de l'ES.
	 * @param listBagages File de bagage.
	 * @param vitesse Vitesse du tapis.
	 * @param topCourant Nombre de topCourant actuel.
	 * @param guichet Guichet relié au tapis.
	 * @param topCourant nb Top horloge courant.
	 * @param vitesse Vitesse du tapis.
	 */
	public Tapis(Noeud noeud, Vector<Bagage> listBagages, int vitesse, 
			int topCourant, int tailleTapis, Guichet guichet) {
		super(noeud);
		this.listBagages = listBagages;
		this.topCourant = topCourant;
		this.tailleTapis = tailleTapis;
		this.guichet = guichet;
	}
	/**
	 * Constructeur utilisable :
	 * 
	 * @param noeud
	 * @param guichet
	 */
	public Tapis(Noeud noeud, Guichet guichet) {
		super(noeud);
		this.guichet = guichet;
		this.tailleTapis = (int) Math.round(guichet.getCoordonnees().distance(
								 noeud.getCoordonnees())/Bagage.TAILLE_BAGAGE);		
		this.listBagages = new Vector<Bagage>(tailleTapis);
		this.listBagages.setSize(tailleTapis);
		this.topCourant = 0;
	}

	/**
	 * Fait avancer le tapis si c'est possible,
	 * met un bagage dans un chariot si c'est possible.
	 */
	public void avancerBagages(){
		topCourant = (topCourant + 1) % vitesse;
		if(topCourant == 0) {
			Bagage b = listBagages.elementAt(tailleTapis-1);
			if(b != null) {
				Chariot c = ((NoeudTapis)(this.getNoeud())).getChariotVide();
				if(c != null) {
					c.mettreBagage(this.getNoeud(), b);
					((NoeudTapis)noeud).avertirChariotPlein();
					listBagages.set(tailleTapis-1, null);
				}
			}
			/*
			 *  On ne connait pas le nombre d'élément
			 *  dans le vecteur, on essai donc le premier
			 *  ou le second selon la vitesse...
			 */
			if(listBagages.elementAt(tailleTapis-1) == null) {
				for(int j = tailleTapis-1; j > 0; j--) {
					listBagages.set(j, listBagages.elementAt(j-1));
				}
				listBagages.set(0, null);
				/*
				if(listBagages.elementAt(tailleTapis-1) != null) {
					if(Aeroport.getMode() == Aeroport.Mode.AUTO) {
						Aeroport.garage.appelerChariot(this.getNoeud());
					}
				}
				*/
			}
		}
	}

	/**
	 * Ajoute un bagage sur le tapis et 
	 * appele un chariot pour le prendre en charge.
	 * 
	 * @param b Bagage à ajouter.
	 * @return Oui si l'opération est possible, non si le tapis est plein.
	 */
	public boolean ajouterBagage(Bagage b) {
		if(listBagages.elementAt(0) != null) {
			return false;
		}
		
		if(Aeroport.getMode() == Aeroport.Mode.AUTO) {
			Aeroport.garage.appelerChariot(this.getNoeud());
		}
		
		listBagages.set(0, b);
		return true;
	}
	public Guichet getGuichet() {
		return guichet;
	}
	public Vector<Bagage> getListBagages() {
		return listBagages;
	}
	
	/**
	 * Appel un chariot pour le bagage en bout
	 * de file en cas de changement de mode.
	 */
	public void appelerChariotBoutDeFile() {
		if(listBagages.elementAt(tailleTapis-1) != null) {
			Aeroport.garage.appelerChariot(this.getNoeud());
		}
	}
	
	public void appelerChariot() {
		for(int i=0; i < tailleTapis; i++) {
			if(listBagages.elementAt(tailleTapis-1) != null) {
				Aeroport.garage.appelerChariot(this.getNoeud());
			}
		}
	}
}
