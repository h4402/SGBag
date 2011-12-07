package vues;

import java.awt.Image;

import noyau.Chariot;
public class VueChariot extends Vue {
	private Chariot chariot;
	
	public VueChariot(VueGeneral vueGeneral, Image image, Chariot chariot) {
		super(vueGeneral, image);
		this.chariot = chariot;
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean clic(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void dessin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void action() {
		// TODO Auto-generated method stub
		
	}
	

}
