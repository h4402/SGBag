package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import noyau.Guichet;
import noyau.Toboggan;

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
			// TODO
		}
	};
	
	public BandeauAjoutBagages(Guichet guichet, Toboggan toboggan) {
		// TODO : get num guichet et toboggan
		int numGuichet = 0;
		int numToboggan = 0;

		labelBagage.setText("Du guichet " + numGuichet + " au toboggan " + numToboggan);
		boutonAjouter.setText("Ajouter");
		boutonAjouter.addActionListener(ajouterListener);
		
		this.add(labelBagage, BorderLayout.WEST);
		this.add(boutonAjouter, BorderLayout.EAST);
		
	}

	
}
