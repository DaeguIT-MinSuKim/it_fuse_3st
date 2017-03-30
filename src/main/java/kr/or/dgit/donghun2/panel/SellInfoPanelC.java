package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class SellInfoPanelC extends JPanel {
	private JPanel pBasic;
	private EmployeeComboPanel pEmployee;
	private ProductComboPanel pProduct;
	private CustomerComboPanel pCustomer;
	private SellInfoPanelB pSellInfo;
	private JPanel pbtn;

	/**
	 * Create the panel.
	 */
	public SellInfoPanelC() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pBasic = new JPanel();
		add(pBasic);
		pBasic.setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmployee = new EmployeeComboPanel();
		pBasic.add(pEmployee);
		
		pProduct = new ProductComboPanel();
		pBasic.add(pProduct);
		
		pCustomer = new CustomerComboPanel();
		pBasic.add(pCustomer);
		
		pSellInfo = new SellInfoPanelB();
		add(pSellInfo);
		
		pbtn = new JPanel();
		add(pbtn);
		
		JButton btnSave = new JButton("저장");
		pbtn.add(btnSave);

	}
	

}
