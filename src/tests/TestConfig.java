package tests;

import ihm.ImagesManager;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import vues.VueGenerale;
import vues.VueGuichet;
import vues.VueRail;

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

	public TestConfig(ImagesManager imagesManager) {
		listRails = new ArrayList<Rail>();
		listGuichets = new ArrayList<Guichet>();
		listToboggans = new ArrayList<Toboggan>();
		listTapis = new ArrayList<Tapis>();
		listNoeuds = new ArrayList<Noeud>();
		listChariots = new LinkedList<Chariot>();
	
		Noeud n1 = new Noeud(0,new Point(50, 350));
		Noeud n2 = new Noeud(1,new Point(50, 200));
		
		//listChariots.add(new Chariot(1, new Point(380, 280), null, 1, null));
		
		Rail r1 = new Rail(null, n1, n2);
		listRails.add(r1);
		n1.getListeRails().add(r1);
		
		
		/*
		VueRail vueRail = new  VueRail(new VueGenerale(null, 
				null, null, null, imagesManager)
		, image, imageSel, rail);
		
		*/

		/*
		listRails.add(new R);
		listChariots.add(new Chariot(1, new Point(380, 280), null, 1, null));
		listToboggans.add(new Toboggan(noeud, null));
		listNoeuds.add(new Noeud(listRailsSortie, coordonnees))
		*/
		
	}

	
	
}
