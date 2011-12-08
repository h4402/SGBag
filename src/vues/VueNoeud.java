package vues;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import noyau.*;
public class VueNoeud extends Vue{

	private Noeud noeud;
	
	public VueNoeud(VueGenerale vueGeneral, Image image, Image imageSel, 
			Image imageGarage, Image imageGarageSel, Noeud noeud) {	
		super(vueGeneral, image, imageSel);
		if(noeud instanceof NoeudGarage){
			this.image = imageGarage;
			this.imageSel = imageGarageSel;
		}
		this.noeud = noeud;
		posPixel = new Point((int)Math.round(this.noeud.getCoordonnees().x * this.vueGenerale.getEchelle() - imageWidth/2)
				, (int)Math.round(this.noeud.getCoordonnees().y * this.vueGenerale.getEchelle() - imageHeight/2));
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth, imageHeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean clic(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	void dessin(Graphics g) {
		if(selection){
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(imageSel, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
		}
		else{
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(image, posPixel.x, posPixel.y, imageWidth, imageHeight, vueGenerale);
		}	
	}

	@Override
	void action() {
		// TODO Auto-generated method stub
		
	}
	

}
