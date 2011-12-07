package vues;

import java.awt.Point;
import java.awt.Rectangle;

import noyau.Toboggan;

public class VueToboggan extends Vue {

	private Toboggan toboggan;
		
	public VueToboggan(VueGeneral vueGeneral, Toboggan unToboggan) {
		super(vueGeneral);
		toboggan = unToboggan;
		posPixel = new Point(toboggan.getCoordoonees().x * vueGeneral.getEchelle()
				, toboggan.getCoordoonees().y * this.vueGeneral.getEchelle());
		rectangle = new Rectangle(posPixel.x-25, posPixel.y-25, 50, 50);
		//TODO Suite
	}
	
	private void updatePos(){
		posPixel.x = toboggan.getCoordoonees().x * this.vueGeneral.getEchelle();
		posPixel.y = toboggan.getCoordoonees().y * this.vueGeneral.getEchelle();
		rectangle.x = posPixel.x - 25;
		rectangle.y = posPixel.y - 25;
	}
	
	@Override
	void dessin() {
		// TODO Auto-generated method stub

	}
	
	@Override
	void action() {
		this.selectionner();
		if(this.vueGeneral.getGuichetCourant() != null){
			this.vueGeneral.afficherBandeau();
		}
		// TODO Auto-generated method stub

	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}
}
