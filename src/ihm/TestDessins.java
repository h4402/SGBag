package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class TestDessins extends JPanel {

	private Image image;
	
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		// TODO : a enlever
		g.setColor(Color.white);
		// On efface l'écran
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
		g.drawOval(50, 50, 50, 50);
		g.fillOval(150, 150, 50, 50);
		g.drawRect(200, 50, 200, 200);

		/*
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(150, 150, 150));
        g2d.fillRect(20, 20, 80, 50);
        g2d.translate(150, 50);
        g2d.fillRect(20, 20, 80, 50);
        g2d.rotate(Math.PI/4);
        g2d.fillRect(20, 20, 80, 50);
        g2d.fillRect(100, 100, 80, 50);
        g2d.fillRect(300, 100, 80, 50);
        */
		
		image = getToolkit().getImage("res/img/bagage.png");
		// G2D c'est mieux
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 50, 100, this);
        /*
        // Sauvegarde de l'ancienne configuration
        // On peut aussi mettre setToIdentity à la fin de la transform
        AffineTransform transform = g2d.getTransform();
        AffineTransform newTransform = (AffineTransform)(transform.clone());
        // Le centre de la rotation est au centre du panel
        int xRot = this.getWidth()/2;
        int yRot = this.getHeight()/2;
        newTransform.rotate(Math.PI/4, xRot, yRot);
        g2d.setTransform(newTransform);
        // Image est dessinée au centre
        int x = (getWidth() - image.getWidth(this))/2;
        int y = (getHeight() - image.getHeight(this))/2;
        g2d.drawImage(image, x, y, this);
        // Retour à l'ancienne transformation
        g2d.setTransform(transform);
        */
        
        /*
         * Méthode à essayer pour récupérer le clic sur une image tournée :
         * - utiliser la méthode d'appartenance d'un point à un polygone
         * - prendre un point extérieur au polygone et compter les intersections
         * avec les aretes
         * - nb intersections impair -> à l'intérieur
         * - pair -> exterieur
         * 
         * Voir g2D.hit()
         */
        
	}
	
	private void dessinerRond(int x, int y) {
		
	}
	
	
}
