package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerConditionPanel extends JPanel {

	
	public CustomerConditionPanel() {
		CustomerTable ct = new CustomerTable();
		add(ct);
	}

}
