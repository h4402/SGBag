package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import vues.VueGenerale;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import noyau.Aeroport;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import bibliotheques.SGBagFileFilter;

/**
 * 
 * @author jeremy
 *
 */
public class FenetrePrincipale extends JFrame {
	
	/**
	 * L'Aéroport 
	 */
	private Aeroport unAeroport;
	
	/**
	 * Vue générale
	 */
	private VueGenerale vueGenerale;
	
	/**
	 * Fichiers
	 */
	private JFileChooser jFileChooserXML;
	
	/**
	 * Menu
	 */
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("Fichier");
	private JMenuItem menuItemOuvrir = new JMenuItem("Ouvrir");
	private JMenu affichageMenu = new JMenu("Affichage");
	private JMenuItem menuItemZoom100 = new JMenuItem("Zoom 100%");
	private JMenuItem menuItemZoomArriere = new JMenuItem("Zoom +");
	private JMenuItem menuItemZoomAvant = new JMenuItem("Zoom -");
	private JMenu aideMenu = new JMenu("Aide");
	private JMenuItem menuItemAPropos = new JMenuItem("A propos");
	private JMenuItem menuItemQuitter = new JMenuItem("Quitter");

	/** 
	 * Panels
	 */
	private JPanel container = new JPanel();
	private JPanel bandeauGeneral = new JPanel();
	private BandeauAjoutBagages bandeauAjoutBagages = new BandeauAjoutBagages();
	private BandeauVitesseChariot bandeauVitesseChariot = new BandeauVitesseChariot();
	private TestDessins testDessins = new TestDessins();
	private JPanel panelBas = new JPanel();
	
	
	/**
	 * Boutons
	 */
	private JButton boutonLecture = new JButton();
	private JButton boutonArretUrgence = new JButton();
	
	/**
	 * Label d'info
	 */
	private final JLabel labelInfo = new JLabel("Label Info");
	
	
	/**
	 * Constantes
	 */
	String playString = "Play";
	String pauseString = "Pause";

	
	/**
	 * Enumérations
	 */
	private enum etatsLecture {
        LECTURE, STOP
    }
	
	
	/**
	 * Clic sur Ouvrir : charge le fichier de configuration
	 */
	private ActionListener ouvrirListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO : charger fichier XML de configuration
			chargerConfiguration();
		}
	};
	
	/**
	 * Clic sur A Propos : ouvre une fenetre d'a propos
	 */
	private ActionListener aboutListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			aboutActionPerformed(actionEvent);
		}
	};
	
	/**
	 * Quitte l'application
	 */
	private ActionListener quitterListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	/**
	 * Clic sur bouton play/pause
	 */
	private ActionListener playPauseListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			if (boutonLecture.getText().equals(playString)) {
				boutonLecture.setText(pauseString);
			} else if (boutonLecture.getText().equals(pauseString)) {
				boutonLecture.setText(playString);
			}
		}
	};
	
	
	/**
	 * Clic sur Arret d'urgence
	 */
	private ActionListener arretUrgenceListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO : vueGeneral.arretUrgence();
		}
	};
	
	/**
	 * Listener sur Panel général
	 */
	private MouseAdapter clicVueGenerale = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			// TODO : appeler methode de vueGenerale pour gestion des clics.
			clicSurVueGenerale(e);
		}
	};
	
	/**
	 * Timer
	 */
	private ActionListener taskPerformer = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
        	// TODO : a chaque tick d'horloge
        	unAeroport.avancerTemps();
        	vueGenerale.redessiner();
        	
        }
    };

    
    
    /**
     * Le Timer pour faire avancer la simulation
     */
    private Timer horloge = new Timer(Aeroport.lapsTemps, taskPerformer);

    
    /**
     * Les fichiers images
     */
    private Image imgChariot = null;
    private Image imgNode = null;
    private Image imgGuichet = null;
    private Image imgToboggan = null;
    private Image imgTapis = null;
    private Image imgRail = null;
    
    final String PATH_IMAGE = "res/img/";
    final String IMG_CHARIOT = PATH_IMAGE+"chariot.png";
    final String IMG_NODE = PATH_IMAGE+"node.png";
    final String IMG_GUICHET = PATH_IMAGE+"node.png";
    final String IMG_TOBOGGAN = PATH_IMAGE+"toboggan.png";
    final String IMG_TAPIS = PATH_IMAGE+"tapis.png";
    final String IMG_RAIL = PATH_IMAGE+"rail.png";
    
	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		jInit();
	}

	private void jInit() {
		this.setTitle("SGBag - Simulation");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setBounds(100, 100, 800, 600);
		this.setJMenuBar(menuBar);
		
		// Chargement des images
		imgChariot = getToolkit().getImage(IMG_CHARIOT);
		imgNode = getToolkit().getImage(IMG_NODE);
	    imgGuichet = getToolkit().getImage(IMG_GUICHET);
	    imgToboggan = getToolkit().getImage(IMG_TOBOGGAN);
	    imgTapis = getToolkit().getImage(IMG_TAPIS);
	    imgRail = getToolkit().getImage(IMG_RAIL);
		
		// Menu Fichier
		menuBar.add(fileMenu);
		menuItemOuvrir.addActionListener(ouvrirListener);
		menuItemOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                KeyEvent.CTRL_MASK));
		fileMenu.add(menuItemOuvrir);
		menuItemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                KeyEvent.CTRL_MASK));
		menuItemQuitter.addActionListener(quitterListener);
		fileMenu.add(menuItemQuitter);
		
		// Menu Affichage
		menuBar.add(affichageMenu);
		menuItemZoom100.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0,
                KeyEvent.CTRL_MASK));
		affichageMenu.add(menuItemZoom100);
		menuItemZoomArriere.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,
                KeyEvent.CTRL_MASK));
		affichageMenu.add(menuItemZoomArriere);
		menuItemZoomAvant.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
                KeyEvent.CTRL_MASK));
		affichageMenu.add(menuItemZoomAvant);
		
		// Menu Aide
		menuBar.add(aideMenu);
		menuItemAPropos.addActionListener(aboutListener);
		aideMenu.add(menuItemAPropos);
		
		// Bouton de lecture
		boutonLecture.setText("Play");
		boutonLecture.addActionListener(playPauseListener);
		boutonLecture.setAlignmentX(LEFT_ALIGNMENT);

		// Bouton d'arret d'urgence
		boutonArretUrgence.setText("STOP!");
		boutonArretUrgence.addActionListener(arretUrgenceListener);
		
		// Panel du bas
		panelBas.add(boutonArretUrgence);
		panelBas.add(boutonLecture);
		panelBas.add(labelInfo);
		
		// Panel Parametres
		// TODO : 
		bandeauAjoutBagages = new BandeauAjoutBagages();
		bandeauVitesseChariot = new BandeauVitesseChariot();
		bandeauAjoutBagages.setVisible(false);
		bandeauVitesseChariot.setVisible(false);
		
		bandeauGeneral.add(bandeauAjoutBagages, BorderLayout.NORTH);
		bandeauGeneral.add(bandeauVitesseChariot, BorderLayout.SOUTH);
		
		// Test : Panel général
		testDessins.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
                testDessinsMouseclicked(e);
            }
		
		});
		
		// Ajout des panels
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(testDessins, BorderLayout.CENTER);
		container.add(panelBas, BorderLayout.SOUTH);
		container.add(bandeauGeneral, BorderLayout.NORTH);
		
		labelInfo.setText("Bienvenue dans le système de gestion de bagages SGBag");
		this.setContentPane(container);
		
	}
	
	/**
	 * Clic sur A Propos
	 * @param e : actionEvent
	 */
	private void aboutActionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(this, new FenetreAbout(), "A Propos", JOptionPane.PLAIN_MESSAGE);
    }
	
	/**
	 * Clic sur le panem vueGenerale
	 * @param e : mouseEvent pour récupérer la position du clic
	 */
	
	private void clicSurVueGenerale(MouseEvent e) {
		vueGenerale.clic(e.getX(), e.getY());
	}
	
	
	/**
	 * Test de dessins
	 * TODO : a supprimer
	 * @param me : mouseEvent
	 */
	private void testDessinsMouseclicked(MouseEvent me) {
        if (me.getX() < testDessins.getWidth()/2) {
        	bandeauAjoutBagages.setVisible(true);
        	bandeauVitesseChariot.setVisible(false);
        } else {
        	bandeauAjoutBagages.setVisible(false);
        	bandeauVitesseChariot.setVisible(true);
        }
	}
	
	/**
	 * Chargement de la configuration
	 */
	public void chargerConfiguration()
	{
		jFileChooserXML = new JFileChooser();
        SGBagFileFilter filter = new SGBagFileFilter();
        filter.addExtension("xml");
        filter.setDescription("Fichier XML");
        jFileChooserXML.setFileFilter(filter);
        jFileChooserXML.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = jFileChooserXML.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("nom de fichier " +
                    jFileChooserXML.getSelectedFile().getAbsolutePath());
            try {
                DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
                DocumentBuilder constructeur = fabrique.newDocumentBuilder();
                File xml = new File(jFileChooserXML.getSelectedFile().getAbsolutePath());
                Document document = constructeur.parse(xml);

                Element racine = document.getDocumentElement();

                if (racine.getNodeName().equals("Aeroport"))
                {
                	if (vueGenerale.construireToutAPartirDeXML(racine) == Aeroport.PARSE_OK)
                	{
                		// unAeroport = vueGenerale.
                		/*leCadre = container.GetVueCadre().GetCadre();*/ /*WTF ?*/
                	}
                }
            // TODO : traiter les erreurs
                
            } catch (ParserConfigurationException pce) {
                System.out.println("Erreur de configuration du parseur DOM");
                System.out.println("lors de l'appel a fabrique.newDocumentBuilder();");
            } catch (SAXException se) {
                System.out.println("Erreur lors du parsing du document");
                System.out.println("lors de l'appel a construteur.parse(xml)");
            } catch (IOException ioe) {
                System.out.println("Erreur d'entree/sortie");
                System.out.println("lors de l'appel a construteur.parse(xml)");
            }
        }  
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
