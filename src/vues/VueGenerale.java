package vues;

import ihm.BandeauAjoutBagages;
import ihm.BandeauSortirChariot;
import ihm.BandeauVitesseChariot;
import ihm.ImagesManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import noyau.Aeroport;
import noyau.Aeroport.Mode;
import noyau.Chariot;
import noyau.Guichet;
import noyau.Noeud;
import noyau.Rail;
import noyau.Tapis;
import noyau.Toboggan;

public class VueGenerale extends JPanel {

	private static final long serialVersionUID = -7005589055229257737L;
	private VueGuichet guichetCourant;
	private VueToboggan tobogganCourant;
	private VueChariot chariotCourant;
	private Aeroport aeroport;
	private BandeauAjoutBagages bandeauAjoutBagages;
	private BandeauVitesseChariot bandeauVitesseChariot;
	private BandeauSortirChariot bandeauSortirChariot;
	private JLabel zoneInfo;
	private double echelle;
	private ArrayList<Vue> listVues;

	/**
	 * Constructeur de VueGenerale
	 * 
	 * @param bandeauAjoutBagages
	 *            : Bandeau qui permet l'appel d'ajouterBaggage
	 * @param bandeauVitesseChariot
	 *            : Bandeau qui permet l'appel de setVitesseChariot
	 * @param bandeauSortirChariot
	 *            : Bandeau qui permet l'appel de libererChariot
	 * @param zoneInfo
	 *            : zone d'affichage des infos d'aide pour l'interface
	 * @param aeroport
	 *            : aeroport a modeliser
	 * @param imagesManager
	 *            : contient les images utilisees pour dessiner les Vues
	 */
	public VueGenerale(BandeauAjoutBagages bandeauAjoutBagages,
			BandeauVitesseChariot bandeauVitesseChariot,
			BandeauSortirChariot bandeauSortirChariot, JLabel zoneInfo,
			Aeroport aeroport, ImagesManager imagesManager) {

		super(new BorderLayout());
		this.setSize(1022, 628);
		this.setPreferredSize(new Dimension(1022, 628));
		this.setBackground(Color.white);

		this.aeroport = aeroport;
		this.bandeauAjoutBagages = bandeauAjoutBagages;
		this.bandeauVitesseChariot = bandeauVitesseChariot;
		this.bandeauSortirChariot = bandeauSortirChariot;
		this.zoneInfo = zoneInfo;

		this.echelle = Math.min(this.getWidth() / this.aeroport.getLargeur(),
				this.getHeight() / this.aeroport.getLongueur());

		listVues = new ArrayList<Vue>();

		List<Chariot> listChariot = aeroport.getListChariots();
		for (Chariot c : listChariot) {
			listVues.add(new VueChariot(this, imagesManager, c));
		}

		List<Guichet> listGuichet = aeroport.getListGuichets();
		for (Guichet g : listGuichet) {
			listVues.add(new VueGuichet(this, imagesManager, g));
		}

		List<Toboggan> listToboggan = aeroport.getListToboggans();
		for (Toboggan t : listToboggan) {
			listVues.add(new VueToboggan(this, imagesManager, t));
		}

		List<Tapis> listTapis = aeroport.getListTapis();
		for (Tapis p : listTapis) {
			listVues.add(new VueTapis(this, imagesManager, p));
		}

		List<Noeud> listNoeuds = aeroport.getListNoeuds();
		for (Noeud n : listNoeuds) {
			listVues.add(new VueNoeud(this, imagesManager, n));
		}

		List<Rail> listRail = aeroport.getListRails();
		for (Rail r : listRail) {
			listVues.add(new VueRail(this, imagesManager, r));
		}

	}

	public VueToboggan getTobogganCourant() {
		return tobogganCourant;
	}

	public void setTobogganCourant(VueToboggan tobogganCourant) {
		this.tobogganCourant = tobogganCourant;
	}

	public BandeauAjoutBagages getBandeauAjoutBagages() {
		return bandeauAjoutBagages;
	}

	public BandeauVitesseChariot getBandeauVitesseChariot() {
		return bandeauVitesseChariot;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public JLabel getZoneInfo() {
		return zoneInfo;
	}

	public double getEchelle() {
		return echelle;
	}

	public void setEchelle(int echelle) {
		this.echelle = echelle;
	}

	public VueGuichet getGuichetCourant() {
		return guichetCourant;
	}

	public void setGuichetCourant(VueGuichet guichetCourant) {
		this.guichetCourant = guichetCourant;
	}

	public VueChariot getChariotCourant() {
		return chariotCourant;
	}

	public void setChariotCourant(VueChariot chariotCourant) {
		this.chariotCourant = chariotCourant;
	}

	public BandeauSortirChariot getBandeauSortirChariot() {
		return bandeauSortirChariot;
	}

	/**
	 * Dessine toutes les Vues
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for (int i = listVues.size() - 1; i >= 0; i--) {
			listVues.get(i).dessin(g);
		}
	}

	/**
	 * Detecte quel objet est clique en X,Y et effectue l'action associee
	 * 
	 * @param x
	 *            : Position x en pixel du clic
	 * @param y
	 *            : Position y en pixel du clic
	 */
	public void clic(int x, int y) {
		int i = 0;
		boolean trouve = false;
		bandeauAjoutBagages.setVisible(false);
		bandeauVitesseChariot.setVisible(false);
		bandeauSortirChariot.setVisible(false);
		zoneInfo.setText("");
		for (Vue v : listVues) {
			v.deselectionner();
		}
		while (i < listVues.size() && !trouve) {
			trouve = listVues.get(i++).clic(x, y);
		}
		if (trouve) {
			listVues.get(i - 1).action();
		} else {
			guichetCourant = null;
			tobogganCourant = null;
			chariotCourant = null;
		}

		repaint();

	}

	/**
	 * Ajoute un bagage entre le guichet courant et le toboggan courant
	 */
	public void ajouterBagage() {
		aeroport.ajouterBagage(guichetCourant.getGuichet(),
				tobogganCourant.getToboggan());
		bandeauAjoutBagages.setVisible(false);
		zoneInfo.setText("");
		guichetCourant.deselectionner();
		tobogganCourant.deselectionner();
		guichetCourant = null;
		tobogganCourant = null;
	}

	/**
	 * Change la vitesse du chariot selectione
	 * 
	 * @param vitesse
	 *            : Nouvelle vitesse du chariot
	 */
	public void setVitesseChariot(float vitesse) {
		if (chariotCourant != null && chariotCourant.getChariot() != null)
			chariotCourant.getChariot().setVitesse(vitesse);
	}

	/**
	 * Fait sortir un chariot du garage
	 */
	public void libererChariot() {
		aeroport.appelChariotGarage();
	}

	/**
	 * Fait avancer le temps dans le noyau
	 */
	public void avancerTemps() {
		aeroport.avancerTemps();
	}

	/**
	 * Declare un arret d'urgence
	 */
	public void toggleAU() {
		aeroport.toggleAU();
	}

	/**
	 * Change le mode courant en AUTO/MANUEL
	 */
	public void changerMode() {
		if (Aeroport.getMode() == Mode.AUTO) {
			aeroport.setMode(Mode.MANUEL);
		} else {
			aeroport.setMode(Mode.AUTO);
		}
	}

	/**
	 * Remplace le imageManager
	 * 
	 * @param imagesManager
	 *            : Nouveau ImageManager
	 */
	public void setImagesManager(ImagesManager imagesManager) {
		for (Vue v : listVues) {
			v.setImagesManager(imagesManager);
		}
	}

}
