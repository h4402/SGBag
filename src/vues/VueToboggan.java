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
		posPixel = new Point(this.toboggan.getCoordonnees().x * this.vueGenerale.getEchelle()
				, this.toboggan.getCoordonnees().y * this.vueGenerale.getEchelle());
		rectangle = new Rectangle(posPixel.x-25, posPixel.y-25, 50, 50);
		//TODO Suite
	}
	
	private void updatePos(){
		posPixel.x = toboggan.getCoordonnees().x * vueGenerale.getEchelle();
		posPixel.y = toboggan.getCoordonnees().y * vueGenerale.getEchelle();
		rectangle.x = posPixel.x - 25;
		rectangle.y = posPixel.y - 25;
	}
	
	@Override
	void dessin(Graphics g) {
		// TODO Auto-generated method stub

	}
	
	@Override
	void action() {
		this.selectionner();
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
		updatePos();
		return dansRectangle(p);
	}
}
