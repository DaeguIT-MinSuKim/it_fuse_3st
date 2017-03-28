package kr.or.dgit.donghun2.table;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;

public class CustomerConditionTable extends JPanel {
	private JTable table;
	private CustomerService dao;

	
	public CustomerConditionTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
	}
	
	
	protected String[] getColumn() {
		return new String[]{"거래일자","제품코드","제품명","판매수량","할인금액","마진액","마진율"};
	}
	
	protected String[][] getRowDate() {
		List<Customer> customers = dao.selectCustomerByAll();
		String[][] datas = new String[customers.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = customers.get(i).toArray();
		}
		return datas;
	}
}
