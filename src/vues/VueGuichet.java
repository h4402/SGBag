package vues;

import java.awt.Point;
import java.awt.Rectangle;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet Guichet;
	public VueGuichet(VueGeneral vueGeneral, Guichet Guichet) {
		super(vueGeneral);
		this.Guichet = Guichet;
		posPixel = new Point(this.Guichet.getCoordoonees().x * this.vueGeneral.getEchelle()
				, Guichet.getCoordoonees().y * this.vueGeneral.getEchelle());
		rectangle = new Rectangle(posPixel.x-25, posPixel.y-25, 50, 50);
		//TODO Suite
	}

	private void updatePos(){
		posPixel.x = this.Guichet.getCoordoonees().x * vueGeneral.getEchelle();
		posPixel.y = this.Guichet.getCoordoonees().y * vueGeneral.getEchelle();
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
		vueGeneral.setGuichetCourant(this.Guichet);
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

}
