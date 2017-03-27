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

public class CustomerTable extends JPanel {
	private JTable table;
	private static CustomerMapper dao;

	/**
	 * Create the panel.
	 */
	public CustomerTable() {
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
		return new String[]{"거래처코드","거래처명","거래처등급"};
	}
	
	protected String[][] getRowDate() {
		List<Customer> vCustomer = dao.selectCustomerByAll();
		String[][] datas = new String[vCustomer.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = vCustomer.get(i).toArray();
		}
		return datas;
	}
	

}
