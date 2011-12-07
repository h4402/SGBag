package noyau;

/**
 * Objet représentant un bagage,
 * avec seulement une destination.
 * 
 * @author H4402
 */
public class Bagage {

	/**
	 * Destination du bagage.
	 */
	private Toboggan toboggan;

	/**
	 * Taille d'un bagage en mètres
	 */
	public static final int TAILLE_BAGAGE = 1;
	
	/**
	 * Constructeur pour GreenUML.
	 * 
	 * @param toboggan
	 */
	public Bagage(Toboggan toboggan) {
		super();
		this.toboggan = toboggan;
	}
	
	/**
	 * Retourne la destination du bagage.
	 * 
	 * @return Toboggan destination du bagage.
	 */
	public Toboggan getTogobban() {
		return toboggan;
	}

}
