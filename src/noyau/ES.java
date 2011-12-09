package noyau;

/**
 * Classe abstraite qui définit la "forme"
 * de tous les objets par lesquels vont entrer ou sortir des
 * bagages et des chariots.
 * 
 * @author H4402
 */
public abstract class ES {

	/**
	 * Noeud associé à l'ES.
	 * 
	 * @uml.property  name="noeud"
	 * @uml.associationEnd  readOnly="true"
	 */
	protected Noeud noeud;
	

	/**
	 * Constructeur utile à GreenUML.
	 * 
	 * @param noeud Noeud associé à l'ES.
	 * @param coordonnees Coordonnées de l'ES.
	 */
	protected ES(Noeud noeud) {
		super();
		this.noeud = noeud;
	}
	
	/**
	 * Constructeur par défault.
	 */
	protected ES() {
		this.noeud = null;
	}
	
	/**
	 * Retourne le noeud associé à l'ES.
	 * 
	 * @return Noeud de l'ES.
	 */
	public Noeud getNoeud() {
		return noeud;
	}
	
	/**
	 * Modifie le noeud associé à l'ES.
	 * 
	 */
	public void setNoeud(Noeud noeud) {
		this.noeud = noeud;
	}
	
}
