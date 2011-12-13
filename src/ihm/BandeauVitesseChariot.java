package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import noyau.Chariot;

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

	
	private int DEFAULT_MIN = 5;
	private int DEFAULT_MAX = 20;
	private int DEFAULT_VALUE = 10;
	
	/**
	 * Champ de saisie de la vitesse du chariot
	 */
	private JSlider sliderVitesseChariot = new JSlider(JSlider.HORIZONTAL,
			DEFAULT_MIN, DEFAULT_MAX, DEFAULT_VALUE);
	
	
	/**
	 * Changement de la vitesse du chariot sur le slider
	 */
	private ChangeListener stateChanged = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (vueGenerale != null)
				vueGenerale.setVitesseChariot(sliderVitesseChariot.getValue());
			
		}
	};
	
	/**
	 * Construit le bandeau vide
	 */
	public BandeauVitesseChariot() {
		labelVitesse.setText("Vitesse chariot : ");
		sliderVitesseChariot.setMajorTickSpacing(5);
		sliderVitesseChariot.setMinorTickSpacing(1);
		sliderVitesseChariot.setPaintTicks(true);
		sliderVitesseChariot.setPaintLabels(true);
		
		sliderVitesseChariot.addChangeListener(stateChanged);
		
		this.add(labelVitesse, BorderLayout.WEST);
		this.add(sliderVitesseChariot, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * Passe la vueGenerale en reference au bandeau
	 * @param vueGenerale
	 */
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
		sliderVitesseChariot.setValue((int) vitesseChariot);
	}
	
	
	public void setValuesSlider(int vMin, int vMax){
		sliderVitesseChariot.setMinimum(vMin);
		sliderVitesseChariot.setMaximum(vMax);
		sliderVitesseChariot.setMajorTickSpacing(5);
		sliderVitesseChariot.setMinorTickSpacing(1);
	}
	
	
}
