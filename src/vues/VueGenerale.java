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

import noyau.*;
import noyau.Aeroport.Mode;
public class VueGenerale extends JPanel {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -7005589055229257737L;
		private VueGuichet guichetCourant;
		private VueToboggan tobogganCourant;
		private VueChariot chariotCourant;
		private VueNoeud noeudCourant;
		private Aeroport aeroport;
		private BandeauAjoutBagages bandeauAjoutBagages;
		private BandeauVitesseChariot bandeauVitesseChariot;
		private BandeauSortirChariot bandeauSortirChariot;
		private JLabel zoneInfo;
		private double echelle;
		private double coefImage;
		private ArrayList<Vue> listVues;

		public VueGenerale(BandeauAjoutBagages bandeauAjoutBagages, BandeauVitesseChariot bandeauVitesseChariot, 
				BandeauSortirChariot bandeauSortirChariot ,JLabel zoneInfo, Aeroport aeroport, ImagesManager imagesManager){
						
            super(new BorderLayout());
            this.setSize(1022,628);
            this.setPreferredSize(new Dimension(1022, 628));
            this.setBackground(Color.white);
                        
			this.aeroport = aeroport;
			this.bandeauAjoutBagages = bandeauAjoutBagages;
			this.bandeauVitesseChariot = bandeauVitesseChariot;
			this.bandeauSortirChariot = bandeauSortirChariot;
			this.zoneInfo = zoneInfo;
			
			//TODO : à réparer y a t'il une inversion entre longueur et largeur ?
			//System.out.printf("this.width: %d, aeroportLong: %d, this.height: %d, aeroportLarg: %d\n", this.getWidth(), this.aeroport.getLongueur(),
				//	this.getHeight(), this.aeroport.getLargeur());
			this.echelle = Math.min(this.getWidth()/this.aeroport.getLargeur(),
					this.getHeight()/this.aeroport.getLongueur());
			
			
			// TODO : supprimer ce coeff 3
			coefImage = 3*Bagage.TAILLE_BAGAGE*echelle;
			listVues = new ArrayList<Vue>();
			
			List<Chariot> listChariot = aeroport.getListChariots();
			for(Chariot c: listChariot){
				listVues.add(new VueChariot(this, imagesManager.getImgChariot(), imagesManager.getImgChariotSel(),
						imagesManager.getImgChariotB(), imagesManager.getImgChariotBSel(), c));
			}
			
			
			List<Guichet> listGuichet = aeroport.getListGuichets();
			for(Guichet g: listGuichet){
				listVues.add(new VueGuichet(this, imagesManager.getImgGuichet(), imagesManager.getImgGuichetSel(), g));
			}
			
			List<Toboggan> listToboggan = aeroport.getListToboggans();
			for(Toboggan t: listToboggan){
				listVues.add(new VueToboggan(this, imagesManager.getImgToboggan(), imagesManager.getImgTobogganSel(), t));
			}
			
			List<Tapis> listTapis = aeroport.getListTapis();
			for(Tapis p : listTapis){
				listVues.add(new VueTapis(this, imagesManager.getImgTapis(), imagesManager.getImgTapisSel(), 
						imagesManager.getImgTapisB(), imagesManager.getImgTapisBSel(), p));
			}
			
			List<Noeud> listNoeuds = aeroport.getListNoeuds();
			for(Noeud n: listNoeuds){
				listVues.add(new VueNoeud(this, imagesManager.getImgNode(), imagesManager.getImgNodeSel(),
						imagesManager.getImgNodeGarage(), imagesManager.getImgNodeGarageSel(), n));
			}
			
			List<Rail> listRail = aeroport.getListRails();
			for(Rail r : listRail){
				listVues.add(new VueRail(this,imagesManager.getImgRail(), imagesManager.getImgRailSel(), r));
			}
			
		}
		
		public double getCoefImage() {
			return coefImage;
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

		public VueNoeud getNoeudCourant() {
			return noeudCourant;
		}

		public void setNoeudCourant(VueNoeud noeudCourant) {
			this.noeudCourant = noeudCourant;
		}

		@Override
		public void paintComponent(Graphics g) {
			//super.paintComponent(g);
            //g.drawOval(50, 50, 50, 50);
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			//System.out.println("vueGenerale.width: "+this.getWidth()+", vueGenerale.height: "+this.getHeight());
			for (int i = listVues.size()-1 ; i >= 0; i--) {
				listVues.get(i).dessin(g);
			}
		}
		
		public void clic(int x, int y) {
			int i = 0;
			boolean trouve = false;
			bandeauAjoutBagages.setVisible(false);
			bandeauVitesseChariot.setVisible(false);
			bandeauSortirChariot.setVisible(false);
			zoneInfo.setText("");
			for (Vue v : listVues ){
				v.deselectionner();
			}
			while (i < listVues.size() && !trouve) {
				trouve = listVues.get(i++).clic(x, y);
			}
			if(trouve){
				listVues.get(i-1).action();
			}
			else{
				guichetCourant = null;
				tobogganCourant = null;
				chariotCourant = null;
				noeudCourant = null;
			}
			
			repaint();
			
		}
		
		public void ajouterBagage(){
			aeroport.ajouterBagage(guichetCourant.getGuichet(), tobogganCourant.getToboggan());
			bandeauAjoutBagages.setVisible(false);
			zoneInfo.setText("");
			guichetCourant = null;
			tobogganCourant = null;
		}
		
		public void setVitesseChariot(float vitesse){
			chariotCourant.getChariot().setVitesse(vitesse);
		}
		
		public void libererChariot() {
			chariotCourant.getChariot().ajouterNoeud(noeudCourant.getNoeud().getListeRails().get(0).getNoeudSortie());
		}
		
		public void avancerTemps(){
			aeroport.avancerTemps();
		}
		
		public void toggleAU(){
			aeroport.toggleAU();
		}
		
		public void changerMode(){
			if(Aeroport.getMode() == Mode.AUTO){
				aeroport.setMode(Mode.MANUEL);
			}
			else{
				aeroport.setMode(Mode.AUTO);
			}
		}
		
		public String getModeBouton(){
			if(Aeroport.getMode() == Mode.AUTO){
				return "Passer en Manuel";
			}
			else{
				return "Passer en Auto";
			}
		}
		
		public String getModeTexte(){
			if(Aeroport.getMode() == Mode.AUTO){
				return "Mode Auto";
			}
			else{
				return "Mode Manuel";
			}
		}
		
}
