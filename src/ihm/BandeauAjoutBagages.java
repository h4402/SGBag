package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import noyau.Guichet;
import noyau.Toboggan;

/**
 * 
 * @author jeremy
 *
 */

public class BandeauAjoutBagages extends JPanel {

	/**
	 * Label
	 */
	private JLabel labelBagage = new JLabel();
	
	
	/**
	 * Bouton d'ajout de bagage
	 */
	private JButton boutonAjouter = new JButton();
	
	
	/**
	 * Clic sur ajouter bagage
	 */
	private ActionListener ajouterListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO : appeler Ajout bagage de vueGeneral
		}
	};
	

	/**
	 * Construit le bandeau sans valeur à mettre dedans
	 */
	public BandeauAjoutBagages() {
		labelBagage.setText("Du guichet .. au toboggan .. : ");
		boutonAjouter.setText("Ajouter");
		boutonAjouter.addActionListener(ajouterListener);
		
		this.add(labelBagage, BorderLayout.WEST);
		this.add(boutonAjouter, BorderLayout.EAST);
		
	}

	/**
	 * Ecrit dans le label d'ajout de bagages
	 * @param numGuichet : id du guichet (départ)
	 * @param numToboggan : id du toboggan (fin)
	 */
	public void setNumeros(int numGuichet, int numToboggan) {
		labelBagage.setText("Du guichet " + numGuichet + " au toboggan " + numToboggan + " : ");
	}
	
}
