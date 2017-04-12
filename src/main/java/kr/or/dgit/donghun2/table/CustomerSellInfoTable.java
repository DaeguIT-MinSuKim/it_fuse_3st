package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CalculatedValueService;

public class CustomerSellInfoTable extends JPanel {
	private JTable table;
	private JLabel lblSum;
	private JLabel lblSum1;
	private JLabel lblSum2;
	private JLabel lblSum3;
	private JLabel lblSum4;
	private static CalculatedValueService dao;

	
	public CustomerSellInfoTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
	
		lblSum = new JLabel("합계");
		lblSum1 = new JLabel("판매 수량");
		lblSum2 = new JLabel("판매 금액");
		lblSum3 = new JLabel("할인 금액");
		lblSum4 = new JLabel("마진액");
		panel.add(lblSum);
		lblSum.setText("합계                   ");
		panel.add(lblSum1);
		lblSum1.setText("판매 수량     "+String.format("%,d", loadSum()[0]));
		panel.add(lblSum2);
		lblSum2.setText("      판매 금액    "+String.format("%,d",loadSum()[1]));
		panel.add(lblSum3);
		lblSum3.setText("      할인 금액    "+String.format("%,d", loadSum()[2]));
		panel.add(lblSum4);
		lblSum4.setText("      마진액    "+String.format("%,d", loadSum()[3]));
		loadDate();
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
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
		cellAlign();
		cellWidth();
	}
	public int[] loadSum(){
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByCustomer();
		int quantity = 0;
		int sellprice = 0;
		int disprice=0;
		int marginprice=0;
		for(int i=0;i<calculatedValues.size();i++){
			quantity = calculatedValues.get(i).getSellinfo().getQuantity();
			sellprice = calculatedValues.get(i).getSellprice();
			disprice = calculatedValues.get(i).getDisprice();
			marginprice = calculatedValues.get(i).getMarginprice();
		}
		return new int[]{quantity,sellprice,disprice,marginprice};
	}
	private void cellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5,6,7);
	}

	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private void cellWidth() {
		tableSetWidth(100, 120, 120, 120, 120);
	}

	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
			;// 컬럼모델 생성해서 가운데 정렬 렌더러 넣어줌
		}
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
