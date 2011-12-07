package vues;
import noyau.*;
public class VueNoeud extends Vue{

	private Noeud noeud;
	
	public VueNoeud(VueGeneral vueGeneral,Noeud noeud) {
		super(vueGeneral);
		this.noeud = noeud;
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
	

}
