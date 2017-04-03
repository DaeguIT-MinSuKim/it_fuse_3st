package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;

public class CustomerComboBoxpanel extends JPanel {

	private JPanel panel;

	private static CustomerService cdao;

	public CustomerComboBoxpanel() {

		ComboPanel<Customer> pCustomerForCombo = new ComboPanel();

		pCustomerForCombo.setTitle("거래처");
		GridBagLayout cgridBagLayout = new GridBagLayout();
		cgridBagLayout.columnWidths = new int[] { 100, 425, 0 };
		cgridBagLayout.rowHeights = new int[] { 51, 0 };
		cgridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		cgridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pCustomerForCombo.setLayout(cgridBagLayout);
		GridBagConstraints cgbc_lbl = new GridBagConstraints();
		cgbc_lbl.fill = GridBagConstraints.BOTH;
		cgbc_lbl.insets = new Insets(0, 0, 0, 5);
		cgbc_lbl.gridx = 0;
		cgbc_lbl.gridy = 0;
		panel.add(pCustomerForCombo, cgbc_lbl);
		GridBagConstraints cgbc_combo = new GridBagConstraints();
		panel.add(pCustomerForCombo, cgbc_combo);

		List<Customer> cList = cdao.getInstance().selectCustomerByAll();
		for (Customer c : cList) {
			System.out.println(c);
		}
		Vector<Customer> cVector = new Vector<>();
		for (int i = 0; i < cList.size(); i++) {
			cVector.addElement(cList.get(i));
		}
		pCustomerForCombo.setcomboData(cVector);
	}
}
