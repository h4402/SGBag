package vues;

import java.awt.Graphics;
import java.awt.Image;

import noyau.Tapis;

public class VueTapis extends Vue {

	private Tapis tapis;
	
	public VueTapis(VueGenerale vueGeneral, Image image, Tapis tapis) {
		super(vueGeneral, image);
		this.tapis = tapis;
		// TODO Auto-generated constructor stub
	}

	@Override
	void dessin(Graphics g) {
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
