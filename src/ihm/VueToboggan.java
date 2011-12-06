package ihm;

import noyau.Toboggan;

public class VueToboggan extends Vue {

	private Toboggan toboggan;
		
	public VueToboggan(Toboggan unToboggan, VueAeroport uneVueAeroport) {
		toboggan = unToboggan;
		vueAeroport = uneVueAeroport;
		//TODO Suite
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
