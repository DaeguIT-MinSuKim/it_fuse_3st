package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.EmployeeTable;

public class EmployeeConditionPanel extends JPanel {

	
	public EmployeeConditionPanel() {
		EmployeeTable et = new EmployeeTable();
		add(et);
	}

}