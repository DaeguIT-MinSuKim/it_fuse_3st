package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.donghun2.dao.CustomerMapper;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.service.EmployeeService;

public class EmployeeTable extends JPanel {
	private JTable table;
	private static EmployeeService dao;

	/**
	 * Create the panel.
	 */
	public EmployeeTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadDate();

	}
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
	}
	
	
	protected String[] getColumn() {
		return new String[]{"사원코드","사원명","사원등급"};
	}
	
	protected String[][] getRowDate() {
		List<Employee> employee = dao.getInstance().selectEmployeeByAll();
		String[][] datas = new String[employee.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = employee.get(i).toArray();
		}
		return datas;
	}
	

}
