package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import vues.VueAeroport;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class FenetrePrincipale extends JFrame {
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
	private JPanel bandeauParametres = new JPanel();
	private TestDessins testDessins = new TestDessins();
	private JPanel panelBas = new JPanel();
	
	
	/**
	 * Bouton de lecture
	 */
	private JButton boutonLecture = new JButton();
	
	
	/**
	 * Label d'info
	 */
	private final JLabel labelInfo = new JLabel("Label Info");
	
	
	/**
	 * Constantes
	 */
	int LAPSE_TEMPS = 20;
	String playString = "Play";
	String pauseString = "Pause";

	
	/**
	 * Clic sur Ouvrir : charge le fichier de configuration
	 */
	private ActionListener ouvrirListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO : charger fichier XML de configuration
		}
	};
	
	/**
	 * Clic sur A Propos : ouvre une fenetre d'a propos
	 */
	private ActionListener aboutListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			helpAbout_ActionPerformed(actionEvent);
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
	 * Timer
	 */
	private ActionListener taskPerformer = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
        	// TODO : a chaque tick d'horloge
        }
    };

    private Timer horloge = new Timer(LAPSE_TEMPS, taskPerformer);

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
		
		// Boutons de lecture
		boutonLecture.setText("Play");
		boutonLecture.addActionListener(playPauseListener);
		boutonLecture.setAlignmentX(LEFT_ALIGNMENT);

		panelBas.add(boutonLecture);
		panelBas.add(labelInfo);
		
		// Ajout des panels
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(testDessins, BorderLayout.CENTER);
		container.add(panelBas, BorderLayout.SOUTH);
		container.add(bandeauParametres, BorderLayout.NORTH);
		
		this.setContentPane(container);
		
		
	}
	
	/**
	 * Clic sur A Propos
	 * @param e : actionEvent
	 */
	void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new FenetreAbout(), "A Propos", JOptionPane.PLAIN_MESSAGE);
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
