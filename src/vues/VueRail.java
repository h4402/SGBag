package vues;

import ihm.ImagesManager;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Aeroport;
import noyau.Rail;
import noyau.Aeroport.Mode;

import java.lang.Math;
public class VueRail extends Vue {
	
	private Rail rail;
	private Point pointA;
	private Point pointB;
	private double alpha;
	
	static private double largeurReelleElem = 1.1;
	static private double longueurReelleElem = 1;

	/**
	 * Constructeur de la VueRail
	 * @param vueGenerale
	 * @param image
	 * @param imageSel
	 * @param rail
	 */
	public VueRail(VueGenerale vueGenerale, ImagesManager imagesManager, Rail rail) {
		super(vueGenerale, imagesManager);
		this.rail = rail;
		
		this.imageWidth = (int)Math.round(longueurReelleElem*vueGenerale.getEchelle());
		this.imageHeight = (int)Math.round(largeurReelleElem*vueGenerale.getEchelle());
		
		constructionRectangle();
	}

	@Override
	boolean clic(int x, int y) {
		if(Aeroport.getMode() == Mode.MANUEL){
			Point p = new Point(x, y);
			return dansRectangle(p);	
		}
		else{
			return false;
		}
	}

	@Override
	void dessin(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(alpha, pointA.x, pointA.y);

		for (int i = 0; i < Math.round(Math.round(pointA.distance(pointB))/imageWidth); i++) {
			if(selection){
				g2d.drawImage(imagesManager.getImgRailSel(), pointA.x + i*imageWidth, pointA.y - imageHeight/2, imageWidth, imageHeight, vueGenerale);
			}
			else{
				g2d.drawImage(imagesManager.getImgRail(), pointA.x + i*imageWidth, pointA.y - imageHeight/2, imageWidth, imageHeight, vueGenerale);
			}
		}
		g2d.rotate(-alpha, pointA.x, pointA.y);
	}

	@Override
	void action() {
		this.selectionner();
		vueGenerale.setGuichetCourant(null);
		vueGenerale.setTobogganCourant(null);
		if(vueGenerale.getChariotCourant()!=null) {
			if(vueGenerale.getChariotCourant().getChariot().noeudElligible(rail.getNoeudSortie())){
				vueGenerale.getChariotCourant().getChariot().ajouterNoeud(rail.getNoeudSortie());
				if(vueGenerale.getChariotCourant().getChariot().getBagage() != null){
					vueGenerale.getZoneInfo().setText("<html>Destination ajoutee, cliquez sur le prochain rail pour definir un chemin <br>" +
							"Chariot " + vueGenerale.getChariotCourant().getChariot().getId() +
							" Bagage a destination du toboggan " + vueGenerale.getChariotCourant().getChariot()
																			 .getBagage().getTogobban().getNoeud().getId() + "</html>");
				}
				else{
					vueGenerale.getZoneInfo().setText("<html>Destination ajoutee, cliquez sur le prochain rail pour definir un chemin <br>" +
							"Chariot " + vueGenerale.getChariotCourant().getChariot().getId() + "</html>");
				}
			}
			else{
				vueGenerale.getZoneInfo().setText("<html>Cette destination n'est pas valide! <br> " +
						"Cliquez sur un rail cons�cutif et dans la bonne direction pour definir un chemin</html>");
			}
		}
	}
	
	/**
	 * On fait la construction du rectangle de detection de clic
	 */
	private void constructionRectangle(){
		pointA = new Point(rail.getNoeudEntree().getCoordonnees());
		pointB = new Point(rail.getNoeudSortie().getCoordonnees());
		pointA.x = (int) Math.round(pointA.getX()*vueGenerale.getEchelle());
		pointA.y = (int) Math.round(pointA.getY()*vueGenerale.getEchelle());
		pointB.x = (int) Math.round(pointB.getX()*vueGenerale.getEchelle());
		pointB.y = (int) Math.round(pointB.getY()*vueGenerale.getEchelle());
		
		//Ici on a les deux points...on va commencer les transformations mathematics pour obtenir le bon rectangle 

		double h = pointB.y - pointA.y;
		double b = pointB.x - pointA.x;
		alpha = Math.atan2(h,b);
		
		rectangle = new Rectangle((int)Math.round(pointA.x), (int)Math.round(pointA.y - imageHeight/2),
				(int) Math.round(pointA.distance(pointB)), imageHeight);
		AffineTransform rotation = AffineTransform.getRotateInstance(alpha, pointA.x, pointA.y);
		rectangle = rotation.createTransformedShape(rectangle);
	}
	

}
