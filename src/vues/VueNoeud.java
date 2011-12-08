package vues;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.*;
public class VueNoeud extends Vue{

	private Noeud noeud;
	
	public VueNoeud(VueGenerale vueGeneral, Image image,Noeud noeud) {
		super(vueGeneral, image);
		this.noeud = noeud;
		posPixel = new Point((int)Math.round(this.noeud.getCoordonnees().x * this.vueGenerale.getEchelle())
				, (int)Math.round(this.noeud.getCoordonnees().y * this.vueGenerale.getEchelle()));
		rectangle = new Rectangle(posPixel.x - image.getHeight(vueGenerale)/2, 
				posPixel.y - image.getWidth(vueGenerale)/2, image.getHeight(vueGenerale),
				image.getWidth(vueGenerale));
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean clic(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void dessin(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void action() {
		// TODO Auto-generated method stub
		
	}
	

}
