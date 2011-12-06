package ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetrePrincipale extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		setTitle("SGBag - Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Fichier");
		menuBar.add(fileMenu);
		
		JMenuItem itemMenuOuvrir = new JMenuItem("Ouvrir");
		fileMenu.add(itemMenuOuvrir);
		
		JMenu affichageMenu = new JMenu("Affichage");
		menuBar.add(affichageMenu);
		
		JMenuItem itemMenuZoom100 = new JMenuItem("Zoom 100%");
		affichageMenu.add(itemMenuZoom100);
		
		JMenuItem itemMenuZoomArriere = new JMenuItem("Zoom +");
		affichageMenu.add(itemMenuZoomArriere);
		
		JMenuItem itemMenuZoomAvant = new JMenuItem("Zoom -");
		affichageMenu.add(itemMenuZoomAvant);
		
		JMenu aideMenu = new JMenu("Aide");
		menuBar.add(aideMenu);
		
		JMenuItem itemMenuAPropos = new JMenuItem("A propos");
		itemMenuAPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				helpAbout_ActionPerformed(actionEvent);
			}
		});
		
		aideMenu.add(itemMenuAPropos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	// Clic sur A Propos
	void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new FenetreAbout(), "A Propos", JOptionPane.PLAIN_MESSAGE);
    }
	
}
