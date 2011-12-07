package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import noyau.Chariot;
import noyau.Guichet;
import noyau.Toboggan;

public class BandeauVitesseChariot extends JPanel {

	/**
	 * Label
	 */
	private JLabel labelVitesse = new JLabel();
	
	
	/**
	 * Bouton de modification vitesse chariot
	 */
	private JButton boutonModifier = new JButton();
	
	
	/**
	 * Champ de saisie de la vitesse du chariot
	 */
	private JTextField textFieldVitesse = new JTextField();
	
	/**
	 * Clic sur modifier
	 */
	private ActionListener modifierListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO
			
		}
	};
	
	public BandeauVitesseChariot(Chariot chariot) {
		// TODO : get num chariot
		int numChariot = 0;

		labelVitesse.setText("Vitesse du chariot n°" + numChariot + " (m/s) : ");
		boutonModifier.setText("Modifier");
		boutonModifier.addActionListener(modifierListener);
		
		textFieldVitesse.setText("");
		textFieldVitesse.setColumns(3);
		
		this.add(labelVitesse, BorderLayout.WEST);
		this.add(textFieldVitesse, BorderLayout.CENTER);
		this.add(boutonModifier, BorderLayout.EAST);
		
	}
	
}
