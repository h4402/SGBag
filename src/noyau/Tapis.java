package noyau;

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
	private final int tailleTapis;
	
	/**
	 * File de bagage.
	 * Gérée en FIFO.
	 * 
	 * @uml.property  name="listBagages"
	 */
	private Bagage[] listBagages;
	
	/**
	 * Vitesse en nombre de top quand faire avancer un bagage.
	 * exemple: 
	 * 	1: On fait avancer un bagage par top horloge.
	 *  2: On fait avancer un bagage pour deux top horloges. 
	 */
	private int vitesse;
	
	/**
	 * Compte le nombre de top passé en rapport à la vitesse;
	 */
	private int topCourant;
	
	private Guichet guichet;
	

	/**
	 * Constructeur pratique pour GreenUML.
	 * 
	 * @param noeud Noeud de l'ES.
	 * @param listBagages File de bagage.
	 * @param vitesse Vitesse du tapis.
	 * @param topCourant Nombre de topCourant actuel.
	 */
	public Tapis(Noeud noeud, Bagage listBagages[], int vitesse, 
			int topCourant, int tailleTapis) {
		super(noeud);
		this.listBagages = listBagages;
		this.vitesse = vitesse;
		this.topCourant = topCourant;
		this.tailleTapis = tailleTapis;
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
		this.listBagages = new Bagage[tailleTapis];//TODO : ça marche ça ?
		this.vitesse = 1;//TODO : faire autre chose en statique c'est moche
		this.topCourant = 0;
	}

	/**
	 * Fait avancer le tapis si c'est possible,
	 * met un bagage dans un chariot si c'est possible.
	 */
	public void avancerBagages(){
		topCourant = ++topCourant % vitesse;
		if(topCourant == 0) {
			Bagage b = listBagages[tailleTapis-1];
			if(b != null) {
				Chariot c = ((NoeudTapis)(this.getNoeud())).getChariotVide();
				if(c != null) {
					c.mettreBagage(this.getNoeud(), b);
				}
			}
			for(int i = tailleTapis; i > 0; i--) {
				listBagages[i] = listBagages[i-1];
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
		
		if(listBagages[0] != null) {
			return false;
		}
		if(Aeroport.mode == Aeroport.Mode.AUTO) {
			Aeroport.garage.appelerChariot(this.getNoeud());
		}
		listBagages[0] = b;
		
		return true;
	}
	public Guichet getGuichet() {
		return guichet;
	}
	public Bagage[] getListBagages() {
		return listBagages;
	}

}
