package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vues.VueGenerale;

/**
 * 
 * @author jeremy
 *
 */

public class BandeauVitesseChariot extends JPanel {

	/**
	 * La vue générale
	 */
	VueGenerale vueGenerale = null;
	
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
			if (vueGenerale != null)
				vueGenerale.setVitesseChariot(Float.valueOf(textFieldVitesse.getText()));
		}
	};
	
	/**
	 * Construit le bandeau vide
	 */
	public BandeauVitesseChariot() {
		labelVitesse.setText("Vitesse chariot : ");
		boutonModifier.setText("Modifier");
		boutonModifier.addActionListener(modifierListener);
		
		textFieldVitesse.setText("");
		textFieldVitesse.setColumns(6);
		
		this.add(labelVitesse, BorderLayout.WEST);
		this.add(textFieldVitesse, BorderLayout.CENTER);
		this.add(boutonModifier, BorderLayout.EAST);
		
	}
	
	
	public void setVueGenerale(VueGenerale vueGenerale) {
		this.vueGenerale = vueGenerale;
	}
	
	/**
	 * Remplit le label du bandeau avec le bon id de chariot
	 * @param numChariot : id du chariot cliqué
	 */
	public void setNumChariot(int numChariot) {
		labelVitesse.setText("Vitesse du chariot n°" + numChariot + " (m/s) : ");
	}
	
	/**
	 * Remplit le textField du bandeau avec la vitesse du chariot
	 * @param vitesseChariot : vitesse du chariot
	 */
	
	public void setVitesseChariot(float vitesseChariot) {
		textFieldVitesse.setText(String.valueOf(vitesseChariot));
	}
	
}
