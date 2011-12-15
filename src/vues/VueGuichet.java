package vues;

import ihm.ImagesManager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Aeroport;
import noyau.Guichet;
import noyau.Aeroport.Mode;

public class VueGuichet extends Vue {

	/**
	 * Objet Guichet du noyau a representer
	 */
	private Guichet guichet;

	/**
	 * Largeur en metre de la representation chariot Sert de base de reference
	 * pour le calcul avec l'echelle
	 */
	static private double hauteurReelle = 2;

	/**
	 * Hauteur en metre de la representation chariot Sert de base de reference
	 * pour le calcul avec l'echelle
	 */
	static private double largeurReelle = 2.7;

	/**
	 * Constructeur de la VueGuichet
	 * 
	 * @param vueGenerale
	 *            : VueGenerale qui possede les informations sur l'etat de
	 *            l'interface
	 * @param imagesManager
	 *            :Gestionnaire des images utilisees pour dessiner les Vues
	 * @param guichet
	 *            : Objet Guichet du noyau a representer
	 */
	public VueGuichet(VueGenerale vueGenerale, ImagesManager imagesManager,
			Guichet guichet) {
		super(vueGenerale, imagesManager);
		this.guichet = guichet;

		this.imageWidth = (int) Math.round(largeurReelle
				* vueGenerale.getEchelle());
		this.imageHeight = (int) Math.round(hauteurReelle
				* vueGenerale.getEchelle());

		posPixel = new Point((int) Math.round(this.guichet.getCoordonnees().x
				* this.vueGenerale.getEchelle() - imageWidth / 2),
				(int) Math.round(this.guichet.getCoordonnees().y
						* this.vueGenerale.getEchelle() - imageHeight / 2));

		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth,
				imageHeight);
	}

	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (selection) {
			g2d.drawImage(imagesManager.getImgGuichetSel(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
		} else {
			g2d.drawImage(imagesManager.getImgGuichet(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
	}

	/**
	 * Action effectuee après le clic sur le toboggan. Si un toboggan est
	 * selectione: Affiche le bandeau d'ajout de bagage
	 */
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(null);
		vueGenerale.setGuichetCourant(this);
		if (vueGenerale.getTobogganCourant() != null) {
			vueGenerale.getTobogganCourant().selectionner();
			vueGenerale.getZoneInfo().setText(
					"Pour ajouter un bagage cliquez sur Valider");
			vueGenerale.getBandeauAjoutBagages().setNumeros(
					vueGenerale.getGuichetCourant().getGuichet().getId(),
					vueGenerale.getTobogganCourant().getToboggan().getNoeud()
							.getId());
			vueGenerale.getBandeauAjoutBagages().setVisible(true);
		} else {
			vueGenerale.getZoneInfo().setText(
					"Veuillez selectionner un toboggan");
		}
	}

	@Override
	boolean clic(int x, int y) {
		if (Aeroport.getMode() == Mode.MANUEL) { // On ne peut selectioner un
													// guichet qu'en mode manuel
			Point p = new Point(x, y);
			return dansRectangle(p);
		} else {
			return false;
		}
	}

	public Guichet getGuichet() {
		return guichet;
	}

}
