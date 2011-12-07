package vues;

import noyau.Tapis;

public class VueTapis extends Vue {

	private Tapis tapis;
	
	public VueTapis(VueGeneral vueGeneral, Tapis unTapis) {
		super(vueGeneral);
		tapis = unTapis;
		// TODO Auto-generated constructor stub
	}

	@Override
	void dessin() {
		// TODO Auto-generated method stub

	}

	@Override
	void action() {
		// TODO Auto-generated method stub

	}

	@Override
	boolean clic(int x, int y) {
		return false;
	}

}
