package vues;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;
	public VueGuichet(VueGeneral vueGeneral, Image image, Guichet guichet) {
		super(vueGeneral, image);
		this.guichet = guichet;
		posPixel = new Point(this.guichet.getCoordoonees().x * this.vueGeneral.getEchelle()
				, this.guichet.getCoordoonees().y * this.vueGeneral.getEchelle());
		rectangle = new Rectangle(posPixel.x - image.getHeight(vueGeneral)/2, 
				posPixel.y - image.getWidth(vueGeneral)/2, image.getHeight(vueGeneral),
				image.getWidth(vueGeneral));
		//TODO Suite
	}

	private void updatePos(){
		posPixel.x = guichet.getCoordoonees().x * vueGeneral.getEchelle();
		posPixel.y = guichet.getCoordoonees().y * vueGeneral.getEchelle();
		rectangle.x = posPixel.x - image.getHeight(vueGeneral)/2;
		rectangle.y = posPixel.y - image.getWidth(vueGeneral)/2;
	}
	
	@Override
	void dessin() {
		// TODO Auto-generated method stub

	}
	
	@Override
	void action() {
		this.selectionner();
		vueGeneral.setGuichetCourant(guichet);
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

}
