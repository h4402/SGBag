package vues;

import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;


import noyau.*;
public class VueGeneral extends JPanel {
	
		private Guichet guichetCourant;
		private Toboggan tobogganCourant;
		private Aeroport aeroport;
		private Noeud noeud;
		private Rail rail;
		private double echelle;
		private Image image;

		@SuppressWarnings("null")
		public VueGeneral(Image imageChariot, Image imageNode,Image imageGuichet,Image imageToboggan, Image imageTapis,Image imageRail){
			List<Vue> listVues = null;
			
			List<Chariot> listChariot = aeroport.getListChariots();
			for(Chariot c: listChariot){
				listVues.add(new VueChariot(this,imageChariot,c));
			}
			
			
			List<Guichet> listGuichet = aeroport.getListGuichets();
			for(Guichet g: listGuichet){
				listVues.add(new VueGuichet(this,image,g));
			}
			
			List<Toboggan> listToboggan = aeroport.getListToboggans();
			for(Toboggan t: listToboggan){
				listVues.add(new VueToboggan(this,imageToboggan,t));
			}
			
			List<Tapis> listTapis = aeroport.getListTapis();
			for(Tapis p : listTapis){
				listVues.add(new VueTapis(this,imageTapis,p));
			}
			
			List<Noeud> listNoeuds = aeroport.getListNoeuds();
			for(Noeud n: listNoeuds){
				listVues.add(new VueNoeud(this,imageNode,n));
			}
			
			List<Rail> listRail = aeroport.getListRails();
			for(Rail r : listRail){
				listVues.add(new VueRail(this,imageRail,r));
			}
			
		}
		public int getEchelle() {
			return echelle;
		}

		public void setEchelle(int echelle) {
			this.echelle = echelle;
		}

		public Guichet getGuichetCourant() {
			return guichetCourant;
		}

		public void setGuichetCourant(Guichet guichetCourant) {
			this.guichetCourant = guichetCourant;
		}
				
		public void ajouterBagage(){
			//aeroport.ajouterBagage(guichetCourant, tobogganCourant);
		}


}
