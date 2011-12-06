package vues;

import java.awt.Point;
import java.awt.Rectangle;

import noyau.Guichet;

public class VueGuichet extends Vue {

	private Guichet guichet;
	
	public VueGuichet(VueAeroport uneVueAeroport, Guichet unGuichet) {
		vueAeroport = uneVueAeroport;
		guichet = unGuichet;
		posPixel = new Point(guichet.getCoordoonees().x * vueAeroport.getEchelle()
				, guichet.getCoordoonees().y * vueAeroport.getEchelle());
		rectangle = new Rectangle(posPixel.x-25, posPixel.y-25, 50, 50);
		//TODO Suite
	}

	private void updatePos(){
		posPixel.x = guichet.getCoordoonees().x * vueAeroport.getEchelle();
		posPixel.y = guichet.getCoordoonees().y * vueAeroport.getEchelle();
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
		vueAeroport.setGuichetCourant(this.guichet);
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

}
