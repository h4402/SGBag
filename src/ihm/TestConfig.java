package ihm;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import vues.VueGuichet;

import noyau.Chariot;
import noyau.Guichet;
import noyau.Noeud;
import noyau.Rail;
import noyau.Tapis;
import noyau.Toboggan;

public class TestConfig {

	
	
	List<Rail> listRails;
	List<Guichet> listGuichets;
	List<Toboggan> listToboggans;
	List<Tapis> listTapis;
	List<Noeud> listNoeuds;
	LinkedList<Chariot> listChariots;

	public TestConfig() {
		listRails = new ArrayList<Rail>();
		listGuichets = new ArrayList<Guichet>();
		listToboggans = new ArrayList<Toboggan>();
		listTapis = new ArrayList<Tapis>();
		listNoeuds = new ArrayList<Noeud>();
		listChariots = new LinkedList<Chariot>();
	
		Noeud n1 = new Noeud(new Point(50, 350));
		Noeud n2 = new Noeud(new Point(50, 200));
		listChariots.add(new Chariot(1, new Point(380, 280), null, 1, null));
		
		Rail r1 = new Rail(listChariots, n1, n2);
		listRails.add(r1);
		
		/*
		listRails.add(new R);
		listChariots.add(new Chariot(1, new Point(380, 280), null, 1, null));
		listToboggans.add(new Toboggan(noeud, null));
		listNoeuds.add(new Noeud(listRailsSortie, coordonnees))
		*/
		
	}
	
	
}
