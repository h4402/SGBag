package vues;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import noyau.Rail;
import java.lang.Math;
public class VueRail extends Vue {
	
	private Rail rail;
	private Point pointA;
	private Point pointB;

	public VueRail(VueGeneral vueGeneral, Image image, Rail rail) {
		super(vueGeneral, image);
		this.rail = rail;
		constructionRectangle(this.rail,vueGeneral);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean clic(int x, int y) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	void dessin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void action() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * On fait la construction du rectangle
	 * @param r rail que on va utiliser pour la construction du rectangle
	 */
	private void constructionRectangle(Rail r,VueGeneral vueGeneral){
		pointA = r.getNoeudEntree().getCoordoonees();
		pointB = r.getNoeudSortie().getCoordoonees();
		pointA.x = (int) Math.round(pointA.getX()*vueGeneral.getEchelle());
		pointA.y = (int) Math.round(pointA.getY()*vueGeneral.getEchelle());
		pointB.x = (int) Math.round(pointB.getX()*vueGeneral.getEchelle());
		pointB.y = (int) Math.round(pointB.getY()*vueGeneral.getEchelle());
		/**
		 * Ici on a les deux points...on va commencer les transformations mathematics pour obtenir le bon rectangle 
		 * 
		 */
		
	}
	

}
