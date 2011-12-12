package vues;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import noyau.*;
import noyau.Aeroport.Mode;
public class VueNoeud extends Vue{

	private Noeud noeud;
	//TODO : set from xml
	static private int tailleReelle = 2;
	
	/**
	 * Constructeur de la vueNoeud
	 * @param vueGeneral
	 * @param image
	 * @param imageSel
	 * @param imageGarage
	 * @param imageGarageSel
	 * @param noeud
	 */
	public VueNoeud(VueGenerale vueGenerale, Image image, Image imageSel, 
			Image imageGarage, Image imageGarageSel, Noeud noeud) {	
		super(vueGenerale, image, imageSel);
		if(noeud instanceof NoeudGarage){
			this.image = imageGarage;
			this.imageSel = imageGarageSel;
		}
		
		this.imageWidth = (int)Math.round(tailleReelle*vueGenerale.getEchelle());
		this.imageHeight = (int)Math.round(tailleReelle*vueGenerale.getEchelle());
		
		this.noeud = noeud;
		
		posPixel = new Point((int)Math.round(this.noeud.getCoordonnees().x * this.vueGenerale.getEchelle() - imageWidth/2)
				, (int)Math.round(this.noeud.getCoordonnees().y * this.vueGenerale.getEchelle() - imageHeight/2));
		
		rectangle = new Rectangle(posPixel.x, posPixel.y, imageWidth, imageHeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		return dansRectangle(p);
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
		// TODO : afficher infos nombre de chariots dans le garage
		if(noeud instanceof NoeudGarage){
			this.selectionner();
			if(Aeroport.getMode() == Mode.MANUEL){
				vueGenerale.getBandeauSortirChariot().setVisible(true);
				vueGenerale.setNoeudCourant(this);
			}
			vueGenerale.getZoneInfo().setText("<html>Chariots presents : " + 
					Aeroport.garage.getListChariotsVides().size()  + 
					"<br>" + "Chariots en attente de depart : " + 
					Aeroport.garage.getListChariotsPourPartir().size()+
					"</html>");
		}
		
	}

	public Noeud getNoeud() {
		return noeud;
	}
	

}
