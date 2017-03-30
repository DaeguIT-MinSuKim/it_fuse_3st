package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import erp_myframework.ComboPanel;

public class ProductComboPanel extends JPanel {

	private ComboPanel pPro;

	/**
	 * Create the panel.
	 */
	public ProductComboPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pPro = new ComboPanel();
		pPro.setTitle("   제   품    ");
		add(pPro);
		pPro.setLayout(new BoxLayout(pPro, BoxLayout.X_AXIS));

	}

}
