package kr.or.dgit.donghun2.Customer;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.CustomerConditionTable;
import kr.or.dgit.donghun2.table.CustomerTable;

public class CustomerConditionPanel extends JPanel {

	
	public CustomerConditionPanel() {
		CustomerConditionTable ct = new CustomerConditionTable();
		add(ct);
	}

}
