package vues;

import ihm.ImagesManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Aeroport;
import noyau.Aeroport.Mode;
import noyau.Toboggan;

public class VueToboggan extends Vue {

	/**
	 * Objet Toboggan du noyau a representer
	 */
	private Toboggan toboggan;
	
	/**
	 * Taille en metre de la representation Toboggan Sert de base de reference
	 * pour le calcul avec l'echelle
	 */
	static private int tailleReelle = 2;

	/**
	 * Constructeur de VueToboggan
	 * @param vueGenerale : VueGenerale qui possede les informations sur l'etat de l'interface
	 * @param imagesManager : Gestionnaire des images utilisees pour dessiner les Vues
	 * @param toboggan : Objet Toboggan du noyau a representer 
	 */
	public VueToboggan(VueGenerale vueGenerale, ImagesManager imagesManager,
			Toboggan toboggan) {
		super(vueGenerale, imagesManager);
		this.toboggan = toboggan;

		this.imageWidth = (int) Math.round(tailleReelle
				* vueGenerale.getEchelle());
		this.imageHeight = (int) Math.round(tailleReelle
				* vueGenerale.getEchelle());

		posPixel = new Point((int) Math.round(this.toboggan.getCoordonnees().x
				* this.vueGenerale.getEchelle() - imageWidth / 2),
				(int) Math.round(this.toboggan.getCoordonnees().y
						* this.vueGenerale.getEchelle() - imageHeight / 2));

		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth,
				imageHeight);
	}

	/**
	 * Dessine le toboggan. Affiche le numero du noeud correspondant au dessus
	 * du dessin
	 */
	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (selection) {
			g2d.drawImage(imagesManager.getImgTobogganSel(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
		} else {
			g2d.drawImage(imagesManager.getImgToboggan(), posPixel.x,
					posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
		if (toboggan.getNoeud().getId() < 10) {
			Font f = new Font("Courier", Font.BOLD, imageWidth);
			g2d.setFont(f);
			g2d.setColor(Color.WHITE);
			g2d.drawString(Integer.toString(toboggan.getNoeud().getId()),
					(float) (posPixel.x + imageWidth / 4),
					(float) (posPixel.y + imageHeight / 1.25));
		} else {
			Font f = new Font("Courier", Font.BOLD,
					(int) Math.round(imageWidth / 1.5));
			g2d.setFont(f);
			g2d.setColor(Color.WHITE);
			g2d.drawString(Integer.toString(toboggan.getNoeud().getId()),
					(float) (posPixel.x + imageWidth / 6),
					(float) (posPixel.y + imageHeight / 1.5));
		}
	}

	/**
	 * Action effectuee après le clic sur le toboggan. Si un guichet est
	 * selectione: Affiche le bandeau d'ajout de bagage
	 */
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(null);
		vueGenerale.setTobogganCourant(this);
		if (vueGenerale.getGuichetCourant() != null) {
			vueGenerale.getGuichetCourant().selectionner();
			vueGenerale.getZoneInfo().setText(
					"Pour ajouter un bagage cliquez sur Valider");
			vueGenerale.getBandeauAjoutBagages().setNumeros(
					vueGenerale.getGuichetCourant().getGuichet().getId(),
					vueGenerale.getTobogganCourant().getToboggan().getNoeud()
							.getId());
			vueGenerale.getBandeauAjoutBagages().setVisible(true);
		} else {
			vueGenerale.getZoneInfo().setText(
					"Veuillez selectionner un Guichet");
		}
	}

	@Override
	boolean clic(int x, int y) {
		if (Aeroport.getMode() == Mode.MANUEL) { // Un toboggan ne se
													// selectionne qu'en mode
													// manuel
			Point p = new Point(x, y);
			return dansRectangle(p);
		} else {
			return false;
		}
	}

	public Toboggan getToboggan() {
		return toboggan;
	}

}
