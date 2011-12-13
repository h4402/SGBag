package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vues.VueGenerale;

/**
 * 
 * @author jeremy
 *
 */

public class BandeauSortirChariot extends JPanel {

	
	/**
	 * Defaut serial version UID
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * La vue Générale
	 */
	VueGenerale vueGenerale = null;
	
	
	/**
	 * Bouton d'ajout de bagage
	 */
	private JButton boutonSortirChariot = new JButton();
	
	/**
	 * Clic sur liberer chariot
	 */
	private ActionListener libererListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (vueGenerale != null)
				vueGenerale.libererChariot();
		}
	};
	
	
	/**
	 * Construit le bandeau sans valeur à mettre dedans
	 */
	public BandeauSortirChariot() {
		boutonSortirChariot.setText("Faire sortir un chariot du garage");
		boutonSortirChariot.addActionListener(libererListener);
		
		this.add(boutonSortirChariot);
		
	}

	public void setVueGenerale(VueGenerale vueGenerale) {
		this.vueGenerale = vueGenerale;
	}
	
}
