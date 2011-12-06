package vues;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;
	
	public VueGuichet(VueAeroport uneVueAeroport, Guichet unGuichet) {
		vueAeroport = uneVueAeroport;
		guichet = unGuichet;
		//TODO Suite
	}

	@Override
	void dessin() {
		// TODO Auto-generated method stub

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

	@Override
	void clic(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
