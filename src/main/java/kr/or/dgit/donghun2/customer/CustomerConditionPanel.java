package kr.or.dgit.donghun2.customer;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.CustomerConditionTable;

public class CustomerConditionPanel extends JPanel {

	
	public CustomerConditionPanel() {
		CustomerConditionTable ct = new CustomerConditionTable();
		add(ct);
	}

}
