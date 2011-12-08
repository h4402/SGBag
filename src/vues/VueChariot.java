package vues;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Chariot;
public class VueChariot extends Vue {
	private Chariot chariot;
	
	public VueChariot(VueGenerale vueGenerale, Image image, Chariot chariot) {
		super(vueGenerale, image);
		this.chariot = chariot;
		posPixel = new Point(this.chariot.getCoordoonees().x * this.vueGenerale.getEchelle()
				, this.chariot.getCoordoonees().y * this.vueGenerale.getEchelle());
		rectangle = new Rectangle(posPixel.x - image.getHeight(vueGenerale)/2, 
				posPixel.y - image.getWidth(vueGenerale)/2, image.getHeight(vueGenerale),
				image.getWidth(vueGenerale));
		// TODO Auto-generated constructor stub
	}

	private void updatePos(){
		posPixel.x = chariot.getCoordoonees().x * vueGenerale.getEchelle();
		posPixel.y = chariot.getCoordoonees().y * vueGenerale.getEchelle();
		rectangle.x = posPixel.x - image.getHeight(vueGenerale)/2;
		rectangle.y = posPixel.y - image.getWidth(vueGenerale)/2;
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
