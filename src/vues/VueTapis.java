package vues;

import java.awt.Image;

import noyau.Tapis;

public class VueTapis extends Vue {

	private Tapis tapis;
	
	public VueTapis(VueGeneral vueGeneral, Image image, Tapis tapis) {
		super(vueGeneral, image);
		this.tapis = tapis;
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
