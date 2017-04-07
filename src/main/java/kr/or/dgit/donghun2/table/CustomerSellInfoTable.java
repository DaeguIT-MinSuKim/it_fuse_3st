package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.CustomerService;

public class CustomerSellInfoTable extends JPanel {
	private JTable table;
	private static CalculatedValueService dao;

	
	public CustomerSellInfoTable() {
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
		return new String[]{"거래일자","제품코드","제품명","판매수량","판매금액","할인금액","마진액","마진율"};
	}
	private String[][] getRowDate(Customer cRes){
		Map<String, String> item= new HashMap<>();
		item.put("ccode", cRes.getCode());
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByCustomerByCode(item);
		String[][] datas = new String[calculatedValues.size()][];
		for(int i=0;i<datas.length;i++){
			
			datas[i] = calculatedValues.get(i).toArrayforCustomerSellInfoByCodeT();
			
		}
		return datas;
	}
	protected String[][] getRowDate() {
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByCustomer();
		String[][] datas = new String[calculatedValues.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = calculatedValues.get(i).toArrayforCustomerSellInfoT();
		}
		return datas;
	}
	public void loadDateByCode(Customer cRes) {
		table.setModel(new DefaultTableModel(getRowDate(cRes),getColumn()));
	}
	public void loadDateByAll(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
	}
	

}
