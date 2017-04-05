package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.donghun2.dao.CustomerMapper;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.CustomerService;
import kr.or.dgit.donghun2.service.EmployeeService;

public class EmployeeSellInfoTable extends JPanel {
	private JTable table;
	private static CalculatedValueService dao;

	/**
	 * Create the panel.
	 */
	public EmployeeSellInfoTable() {
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
		return new String[]{"사원코드","사원명","판매금액","마진액","마진율"};
	}
	
	public void loadDateByCode(Employee eRes) {
		table.setModel(new DefaultTableModel(getRowDate(eRes),getColumn()));
		
	}
	
	private String[][] getRowDate(Employee eRes) {
		Map<String, String> item = new HashMap<>();
		item.put("ecode", eRes.getCode());
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByEmployeeByCode(item);
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
		String[][] datas = new String[calculatedValues.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = calculatedValues.get(i).toArrayforEmployeeSellInfoByCodeT();
		}
		return datas;
	}
	
	
	protected String[][] getRowDate() {
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByEmployee();
		String[][] datas = new String[calculatedValues.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = calculatedValues.get(i).toArrayforEmployeeSellInfoT();
		}
		return datas;
	}
	
	

}
