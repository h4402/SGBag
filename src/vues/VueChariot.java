package vues;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Chariot;
public class VueChariot extends Vue {
	private Chariot chariot;
	
	public VueChariot(VueGeneral vueGeneral, Image image, Chariot chariot) {
		super(vueGeneral, image);
		this.chariot = chariot;
		posPixel = new Point(this.chariot.getCoordoonees().x * this.vueGeneral.getEchelle()
				, this.chariot.getCoordoonees().y * this.vueGeneral.getEchelle());
		rectangle = new Rectangle(posPixel.x - image.getHeight(vueGeneral)/2, 
				posPixel.y - image.getWidth(vueGeneral)/2, image.getHeight(vueGeneral),
				image.getWidth(vueGeneral));
		// TODO Auto-generated constructor stub
	}

	private void updatePos(){
		posPixel.x = chariot.getCoordoonees().x * vueGeneral.getEchelle();
		posPixel.y = chariot.getCoordoonees().y * vueGeneral.getEchelle();
		rectangle.x = posPixel.x - image.getHeight(vueGeneral)/2;
		rectangle.y = posPixel.y - image.getWidth(vueGeneral)/2;
	}
	
	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		updatePos();
		return dansRectangle(p);
	}

	@Override
	void dessin() {
		this.selectionner();
		// TODO Auto-generated method stub
		
	}

	@Override
	void action() {
		// TODO Auto-generated method stub
		
	}
	

}
