package vues;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import noyau.Toboggan;

public class VueToboggan extends Vue {

	private Toboggan toboggan;
		
	public VueToboggan(VueGenerale vueGenerale, Image image, Toboggan toboggan) {
		super(vueGenerale, image);
		this.toboggan = toboggan;
		posPixel = new Point((int)Math.round(this.toboggan.getCoordonnees().x * this.vueGenerale.getEchelle())
				, (int)Math.round(this.toboggan.getCoordonnees().y * this.vueGenerale.getEchelle()));
		rectangle = new Rectangle(posPixel.x - image.getHeight(vueGenerale)/2, 
				posPixel.y - image.getWidth(vueGenerale)/2, image.getHeight(vueGenerale),
				image.getWidth(vueGenerale));
		//TODO Suite
	}
	
	@Override
	void dessin(Graphics g) {
		// TODO Auto-generated method stub

	}
	
	@Override
	void action() {
		this.selectionner();
		vueGenerale.setChariotCourant(null);
		vueGenerale.setTobogganCourant(this.toboggan);
		if(vueGenerale.getGuichetCourant() != null){
			vueGenerale.getZoneInfo().setText("Pour ajouter un bagage cliquez sur Valider");
			vueGenerale.getBandeauAjoutBagages().setNumeros(vueGenerale.getGuichetCourant().getId(), 
					vueGenerale.getTobogganCourant().getId());
			vueGenerale.getBandeauAjoutBagages().setVisible(true);
		}
		else{
			vueGenerale.getZoneInfo().setText("Veuillez selectionner un Guichet");
		}
	}

	@Override
	boolean clic(int x, int y) {
		Point p = new Point(x, y);
		return dansRectangle(p);
	}
}
