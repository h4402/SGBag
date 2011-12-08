package vues;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.*;
public class VueNoeud extends Vue{

	private Noeud noeud;
	private Image imageGarage;
	
	public VueNoeud(VueGenerale vueGeneral, Image image, Image imageGarage, Noeud noeud) {
		super(vueGeneral, image);
		this.noeud = noeud;
		this.imageGarage = imageGarage;
		posPixel = new Point((int)Math.round(this.noeud.getCoordonnees().x * this.vueGenerale.getEchelle() - image.getHeight(vueGenerale)/2)
				, (int)Math.round(this.noeud.getCoordonnees().y * this.vueGenerale.getEchelle() - image.getWidth(vueGenerale)/2));
		rectangle = new Rectangle(posPixel.x, posPixel.y, image.getHeight(vueGenerale), image.getWidth(vueGenerale));
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean clic(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, posPixel.x, posPixel.y, vueGenerale);	
	}

	@Override
	void action() {
		// TODO Auto-generated method stub
		
	}
	

}
