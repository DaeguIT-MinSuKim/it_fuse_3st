package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeTable extends JPanel{
	private JTable table;
	private static EmployeeService employeeService;
	
	public EmployeeTable(){
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane,BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadDate();
	}

	public void loadDate() {
		table.setModel(new DefaultTableModel(getRowDate(), getColumn()));
	}

	private String[] getColumn() {
		return new String[]{"사원코드","사원명","사원등급"};
	}

	private String[][] getRowDate() {
		List<Employee> vEmployee = employeeService.getInstance().selectEmployeeByAll();
		String[][] datas = new String[vEmployee.size()][];
		for(int i=0; i<datas.length;i++){
			datas[i]=vEmployee.get(i).toArray();
		}
		return datas;
	}
}