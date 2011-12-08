package vues;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Toboggan;

public class VueToboggan extends Vue {

	private Toboggan toboggan;
		
	public VueToboggan(VueGenerale vueGenerale, Image image, Toboggan toboggan) {
		super(vueGenerale, image);
		this.toboggan = toboggan;
		posPixel = new Point(this.toboggan.getCoordoonees().x * this.vueGenerale.getEchelle()
				, this.toboggan.getCoordoonees().y * this.vueGenerale.getEchelle());
		rectangle = new Rectangle(posPixel.x-25, posPixel.y-25, 50, 50);
		//TODO Suite
	}
	
	private void updatePos(){
		posPixel.x = toboggan.getCoordoonees().x * vueGenerale.getEchelle();
		posPixel.y = toboggan.getCoordoonees().y * vueGenerale.getEchelle();
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
		if(vueGenerale.getGuichetCourant() != null){
			vueGenerale.afficherBandeau();
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
