package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import erp_myframework.ComboPanel;

public class CustomerComboPanel extends JPanel {

	private ComboPanel pCus;

	/**
	 * Create the panel.
	 */
	public CustomerComboPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		pCus = new ComboPanel();
		pCus.setTitle("  거 래 처  ");
		add(pCus);
		pCus.setLayout(new BoxLayout(pCus, BoxLayout.X_AXIS));

	}

}
