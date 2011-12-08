package vues;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;
	public VueGuichet(VueGenerale vueGeneral, Image image, Guichet guichet) {
		super(vueGeneral, image);
		this.guichet = guichet;
		posPixel = new Point((int)Math.round(this.guichet.getCoordoonees().x * this.vueGenerale.getEchelle())
				, (int)Math.round(this.guichet.getCoordoonees().y * this.vueGenerale.getEchelle()));
		rectangle = new Rectangle(posPixel.x - image.getHeight(vueGeneral)/2, 
				posPixel.y - image.getWidth(vueGeneral)/2, image.getHeight(vueGeneral),
				image.getWidth(vueGeneral));
		//TODO Suite
	}

	private void updatePos(){
		posPixel.x = (int)Math.round(guichet.getCoordoonees().x * vueGenerale.getEchelle());
		posPixel.y = (int)Math.round(guichet.getCoordoonees().y * vueGenerale.getEchelle());
		rectangle.x = posPixel.x - image.getHeight(vueGenerale)/2;
		rectangle.y = posPixel.y - image.getWidth(vueGenerale)/2;
	}
	
	@Override
	void dessin() {
		// TODO Auto-generated method stub

	}
	
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setGuichetCourant(guichet);
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

}
