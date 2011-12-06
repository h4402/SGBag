package vues;

import noyau.Toboggan;

public class VueToboggan extends Vue {

	private Toboggan toboggan;
		
	public VueToboggan(VueAeroport uneVueAeroport, Toboggan unToboggan) {
		vueAeroport = uneVueAeroport;
		toboggan = unToboggan;
		//TODO Suite
	}
	
	@Override
	void dessin() {
		// TODO Auto-generated method stub

	}
	
	@Override
	void action() {
		this.selectionner();
		if(vueAeroport.guichetCourant != null){
				vueAeroport.afficherBandeau();
		}
		// TODO Auto-generated method stub

	}
}
