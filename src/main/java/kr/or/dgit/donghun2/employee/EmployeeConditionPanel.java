package kr.or.dgit.donghun2.employee;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.EmployeeConditionTable;

public class EmployeeConditionPanel extends JPanel {

	
	public EmployeeConditionPanel() {
		EmployeeConditionTable et = new EmployeeConditionTable();
		add(et);
	}

}
