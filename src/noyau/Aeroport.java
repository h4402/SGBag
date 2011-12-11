package noyau;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * La classe principale du noyau, celle qui connait
 * tout le monde, qui fait avancer les chariots...
 * 
 * @author H4402
 */
public class Aeroport {
	
	public List<Noeud> getListNoeuds() {
		return listNoeuds;
	}

	public void setListNoeuds(List<Noeud> listNoeuds) {
		this.listNoeuds = listNoeuds;
	}

	public List<Rail> getListRails() {
		return listRails;
	}

	public void setListRails(List<Rail> listRails) {
		this.listRails = listRails;
	}

	public List<Guichet> getListGuichets() {
		return listGuichets;
	}

	public List<Chariot> getListChariots() {
		return listChariots;
	}

	public void setListChariots(List<Chariot> listChariots) {
		this.listChariots = listChariots;
	}

	public void setListGuichets(List<Guichet> listGuichets) {
		this.listGuichets = listGuichets;
	}

	public List<Toboggan> getListToboggans() {
		return listToboggans;
	}

	public void setListToboggans(List<Toboggan> listToboggans) {
		this.listToboggans = listToboggans;
	}

	public List<Tapis> getListTapis() {
		return listTapis;
	}

	public void setListTapis(List<Tapis> listTapis) {
		this.listTapis = listTapis;
	}
	
	public static Mode getMode() {
		return mode;
	}

	public static void setMode(Mode mode) {
		Aeroport.mode = mode;
	}

	/**
	 * Temps entre chaque tick en millisecondes.
	 */
	public static final int lapsTemps = 20;

	/**
	 * Le mode sera choisi
	 * dans un autre espace.
	 */
	public static enum Mode {
		AUTO,
		MANUEL
	};
	
	/**
	 * Indicateur de réussite du parsing
	 */
	public final static int PARSE_OK = 1;
	public final static int PARSE_ERROR = 0;
	
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
	 * Liste des chariots pour les faire avancer.
	 */
	private List<Chariot> listChariots;
	
	/**
	 * Longueur de l'aéroport en mètres
	 */
	private int longueur;
	
	/**
	 * Largeur de l'aéroport en mètres
	 */
	private int largeur;
	
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
			List<Toboggan> listToboggans, List<Tapis> listTapis,
			List<Noeud> listNoeuds, List<Chariot> listChariots) {
		super();
		this.listRails = listRails;
		this.listGuichets = listGuichets;
		this.listToboggans = listToboggans;
		this.listTapis = listTapis;
		this.listNoeuds = listNoeuds;
		this.listChariots= listChariots; 
		genRan = new Random();
	}
	
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
	public Aeroport() {
		super();
		this.listRails = new ArrayList<Rail>();
		this.listGuichets = new ArrayList<Guichet>();
		this.listToboggans = new ArrayList<Toboggan>();
		this.listTapis = new ArrayList<Tapis>();
		this.listNoeuds = new ArrayList<Noeud>();
		this.listChariots= new ArrayList<Chariot>(); 
		genRan = new Random();
	}
	
	/**
	 * Permet d'ajouter un chariot à l'aéroport
	 * 
	 * @param chariot Chariot à ajouter
	 */
	public void ajouterChariot(Chariot chariot)
	{
		this.listChariots.add(chariot);
		garage.ajouterChariotVide(chariot);
	}
	
	/**
	 * Permet d'ajouter un tapis à l'aéroport
	 * 
	 * @param tapis Tapis à ajouter
	 */
	public void ajouterTapis(Tapis tapis)
	{
		this.listTapis.add(tapis);
	}
	
	/**
	 * Permet d'ajouter un toboggan à l'aéroport
	 * 
	 * @param toboggan Toboggan à ajouter
	 */
	public void ajouterToboggan(Toboggan toboggan)
	{
		this.listToboggans.add(toboggan);
	}
	
	/**
	 * Permet d'ajouter un rail à l'aéroport
	 * 
	 * @param rail Rail à ajouter
	 */
	public void ajouterRail(Rail rail)
	{
		this.listRails.add(rail);
	}
	
	/**
	 * Permet d'ajouter un noeud à l'aéroport
	 * 
	 * @param noeud Noeud à ajouter
	 */
	public void ajouterNoeud(Noeud noeud)
	{
		this.listNoeuds.add(noeud);
	}
	
	/**
	 * Permet d'ajouter un guichet à l'aéroport
	 * 
	 * @param guichet Guichet à ajouter
	 */
	public void ajouterGuichet(Guichet guichet)
	{
		this.listGuichets.add(guichet);
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
			Bagage b = new Bagage(listToboggans.get(genRan.nextInt(listToboggans.size())));
			for (Guichet g : listGuichets) {
				//System.out.println("On ajoute un bagage");
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
	
	public int getLongueur() {
		return longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	/**
	 * Ajoute un bagage dans un guichet,
	 * avec un destination.
	 * 
	 * @param g Guichet où ajouter le bagage.
	 * @param t Destination du bagage.
	 */
	public void ajouterBagage(Guichet g, Toboggan t) {
		Bagage b = new Bagage(t);
		g.ajoutBagage(b);
	}
	
	/**
	 * Retourne la liste des rails de l'application
	 * @return Liste de rails
	 */
	public List<Rail> getListeRails() {
		return this.listRails;
	}
	
	/**
	 * Retourne la liste des noeuds de l'application
	 * @return Liste de noeuds
	 */
	public List<Noeud> getListeNoeuds() {
		return this.listNoeuds;
	}

	/**
	 * Retourne un noeud à partir de son id
	 * 
	 * @param id Identifiant du noeud
	 * @return Noeud
	 */
	public Noeud getNoeud(int id)
	{
		//Si la liste est rangée, on est directement au bon index
		if(listNoeuds.size()>id&&listNoeuds.get(id).id==id) {
			return listNoeuds.get(id);
		}
		
		//Sinon on le cherche dans la liste
		for (Noeud unNoeud : listNoeuds) {
			if(unNoeud.id==id) {
				return unNoeud;
			}
		}
		
		//Si on est ici c'est qu'il est introuvable.
		return null;
		
		
		//TODO:trouver une meilleure solution, initialement :
		//ici on retourne le noeud à la position id dans la liste, ce n'est
		//pas forcément le noeud ayant pour id "id". J'ai modifié le add pour
		//que ce soit le cas mais il faut faire gaffe.
		//return this.listNoeuds.get(id);
	}
	
	/**
	 * Reset pour la reconstruction de l'aeroport.
	 */
	private void reset() {
		this.listRails.clear();
		this.listGuichets.clear();
		this.listToboggans.clear();
		this.listTapis.clear();
		this.listNoeuds.clear();
		this.listChariots.clear(); 
		genRan = new Random();
		mode = Mode.MANUEL;
		largeur = 0;
		longueur = 0;
	}
	
	public int construireAPartirDeXML(Element aeroportElement)
	{	
		this.reset();
		// On récupère les attributs de l'aéroports
        this.longueur = Integer.parseInt(aeroportElement.getAttribute("longueur"));
        this.largeur = Integer.parseInt(aeroportElement.getAttribute("largeur"));
        
        //TODO ajouter dans les fichiers de config et récupérer pour mise à jour,
        //les vitesses des tapis, la taille des bagages et autres...

        // TODO on supprime la config existante et on la remplace par la nouvelle
        //lesBoules.removeAllElements();
        
        //création des Rails/Chariots/...
        NodeList listeNoeuds    = aeroportElement.getElementsByTagName("Noeud");
        NodeList listeRails     = aeroportElement.getElementsByTagName("Rail");
        NodeList listeGuichets  = aeroportElement.getElementsByTagName("Guichet");
        NodeList listeToboggans = aeroportElement.getElementsByTagName("Toboggan");
        NodeList listeChariots  = aeroportElement.getElementsByTagName("Chariots");
        
		// On parcourt la liste des noeuds récupérés pour créer les objets correspondants
		for (int i = 0; i < listeNoeuds.getLength(); i++)
		{
            Element noeudElement = (Element) listeNoeuds.item(i);
            Noeud noeud = new Noeud();
			
			// On vérifie que la création du noeud à partir du XML n'a pas échoué
            if (noeud.construireAPartirDeXML(noeudElement)!= Aeroport.PARSE_OK){
                return Aeroport.PARSE_ERROR;
            }
            ajouterNoeud(noeud);
        }
		
		// Création du garage correspondant au noeud par défaut d'apparition des chariots
             
		Garage garage = new Garage();
		Aeroport.garage = garage;
		
		Element chariotElement = (Element) listeChariots.item(0);
		if (garage.construireAPartirDeXML(chariotElement, this)!= Aeroport.PARSE_OK){
            return Aeroport.PARSE_ERROR;
        }
		
		// On parcourt la liste des rails récupérés pour créer les objets correspondants
		for (int i = 0; i < listeRails.getLength(); i++)
		{
            Element railElement = (Element) listeRails.item(i);
            Rail rail = new Rail();
			
			// On vérifie que la création du rail à partir du XML n'a pas échoué
            if (rail.construireAPartirDeXML(railElement, this)!= Aeroport.PARSE_OK){
                return Aeroport.PARSE_ERROR;
            }
            ajouterRail(rail);
        }
		
		// On parcourt la liste des guichets récupérés pour créer les objets correspondants
		for (int i = 0; i < listeGuichets.getLength(); i++)
		{
            Element guichetElement = (Element) listeGuichets.item(i);
            Guichet guichet = new Guichet();
			
			// On vérifie que la création du noeud à partir du XML n'a pas échoué
            if (guichet.construireAPartirDeXML(guichetElement, this)!= Aeroport.PARSE_OK){
                return Aeroport.PARSE_ERROR;
            }
            
            ajouterGuichet(guichet);
        }
		
		// On parcourt la liste des toboggans récupérés pour créer les objets correspondants
		for (int i = 0; i < listeToboggans.getLength(); i++)
		{
            Element tobogganElement = (Element) listeToboggans.item(i);
            Toboggan toboggan = new Toboggan();
			
			// On vérifie que la création du noeud à partir du XML n'a pas échoué
            if (toboggan.construireAPartirDeXML(tobogganElement, this)!= Aeroport.PARSE_OK){
                return Aeroport.PARSE_ERROR;
            }
            
            ajouterToboggan(toboggan);
        }

		int nbChariot = Integer.parseInt(chariotElement.getAttribute("nbChariots"));
		for (int i = 0; i < nbChariot; i++) {
			
            Chariot chariot= new Chariot(i);
			
			// On vérifie que la création du noeud à partir du XML n'a pas échoué
            if (chariot.construireAPartirDeXML(chariotElement, this)!= Aeroport.PARSE_OK){
                return Aeroport.PARSE_ERROR;
            }
            
            ajouterChariot(chariot);
        }
		
		
		
        return PARSE_OK;
	}

}

