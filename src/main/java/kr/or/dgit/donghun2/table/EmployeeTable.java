package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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

	public void loadDate() {
		table.setModel(new DefaultTableModel(getRowDate(), getColumn()));
		cellAlign();
		cellWidth();
	}

	private void cellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
	}

	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel tcm = table.getColumnModel();
		for(int i = 0; i < idx.length; i++){
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
	private void cellWidth() {
		tableSetWidth(100, 120, 120);
	}
	
	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<width.length; i++){
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected String[] getColumn() {
		return new String[] { "사원코드", "사원명", "사원등급" };
		
	}
	
	protected String[][] getRowDate() {
		List<Employee> employee = dao.getInstance().selectEmployeeByAll();
		for(int i=employee.size()-1;i>=0;i--){
			if(employee.get(i).isIsexist()==false){
				employee.remove(i);
			}
		}
		
		String[][] datas = new String[employee.size()][];
		for (int i = 0; i < datas.length; i++) {
			if (employee.get(i).isIsexist()) {
				datas[i] = employee.get(i).toArray();
			}
		}
		return datas;
	}

}
