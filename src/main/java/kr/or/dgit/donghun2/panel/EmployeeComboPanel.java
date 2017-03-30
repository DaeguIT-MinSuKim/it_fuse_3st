package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import erp_myframework.ComboPanel;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.EmployeeService;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EmployeeComboPanel extends JPanel{

	private ComboPanel pEmp;
	private static EmployeeService dao;
	
	
	public EmployeeComboPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		
		pEmp = new ComboPanel<>();
		pEmp.setTitle("   사   원    ");
		
		pEmp.setLayout(new BoxLayout(pEmp, BoxLayout.X_AXIS));
		
	}
	
	


	
}
