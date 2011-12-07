package noyau;

import java.util.List;
import java.util.Random;

/**
 * La classe principale du noyau, celle qui connait
 * tout le monde, qui fait avancer les chariots...
 * 
 * @author H4402
 */
public class Aeroport {
	
	/**
	 * Le mode sera choisi
	 * dans un autre espace.
	 */
	public static enum Mode {
		AUTO,
		MANUEL
	};
	
	/**
	 * Le mode indique si l'on est en mode
	 * manuel ou automatique.
	 * Les traitements du top horloge ne sont pas les memes.
	 */
	public static Mode mode; 
	
	/**
	 * Il n'y a qu'un garage qui est commun à tous 
	 * les objets.
	 */
	public static Garage garage;

	/**
	 * Liste des noeuds de l'application
	 */
	private List<Noeud> listNoeuds;
	
	/**
	 * Liste des rails de l'application.
	 * 
	 * @uml.property  name="listRails"
	 */
	private List<Rail> listRails;
	
	/**
	 * Liste des guichets de l'application.
	 * 
	 * @uml.property  name="listGuichets"
	 */
	private List<Guichet> listGuichets;
	
	
	/**
	 * Liste des toboggans pour mettre
	 * une destination dans le bagage si on est en mode auto.
	 * 
	 * @uml.property  name="listToboggans"
	 */
	private List<Toboggan> listToboggans;
	
	/**
	 * Liste des tapis pour les faire avancer.
	 */
	private List<Tapis> listTapis;
	
	/**
	 * Générateur de nombre aléatoire.
	 */
	private Random genRan;

	/**
	 * Constructeur permettant de se mettre d'accord avec 
	 * GreenUML.
	 * 
	 * @param listRails Liste des rails de l'application.
	 * @param listGuichets Liste des guichets de l'application.
	 * @param listTapis Liste des tapis de l'application.
	 * @param listToboggans Liste des toboggans de l'application.
	 * @param listNoeuds Liste des noeuds de l'application
	 */
	public Aeroport(List<Rail> listRails, List<Guichet> listGuichets,
			List<Toboggan> listToboggans, List<Tapis> listTapis, List<Noeud> listNoeuds) {
		super();
		this.listRails = listRails;
		this.listGuichets = listGuichets;
		this.listToboggans = listToboggans;
		this.listTapis = listTapis;
		this.listNoeuds = listNoeuds;
		genRan = new Random();
	}

	/**
	 * Méthode à appeler à chaque top horloge.
	 * Cette méthode va faire avancer les chariots,
	 * lancer des bagages aux guichets, 
	 * faire avancer les tapis de bagages
	 * dans les chariots et faire avancer
	 * les chariots vides des garages si 
	 * ils veulent partir.
	 */
	public void avancerTemps() {
		
		/*
		 * On fait avancer les chariots sur les rails.
		 */
		for (Rail r : listRails) {
			r.avancerChariots();
		}
		
		/* 
		 * Si le mode est auto, on ajoute des bagages
		 * aux guichets.
		 */
		if(mode == Mode.AUTO) {
			Bagage b = new Bagage(listToboggans.get(genRan.nextInt()%listToboggans.size()));
			for (Guichet g : listGuichets) {
				g.ajoutBagage(b);
			}
		}
		
		/*
		 * On fait avancer les bagages sur les tapis. 
		 */
		for (Tapis t : listTapis) {
			t.avancerBagages();
		}
		
		/*
		 * Au cas où des chariots doivent aller
		 * chercher un bagage mais sont bloqués 
		 * dans le garage, on essai de les faire sortir.
		 */
		garage.faireSortirAttente();
		
	}
	
	/**
	 * Retourne un noeud à partir de son id
	 * 
	 * @param id Identifiant du noeud
	 * @return Noeud
	 */
	public Noeud getNoeud(int id)
	{
		return this.listNoeuds.get(id);
	}

}

