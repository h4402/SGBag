package vues;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;
	
	public VueGuichet(Guichet unGuichet, VueAeroport uneVueAeroport) {
		guichet = unGuichet;
		vueAeroport = uneVueAeroport;
		//TODO Suite
	}

	@Override
	void action() {
		this.selectionner();
		if(guichet.placeDisponible()){
			vueAeroport.guichetCourant = this;
		}
		else{
			vueAeroport.zoneInfo("Guichet Saturé");			
		}
		
		// TODO Auto-generated method stub
	}

}
