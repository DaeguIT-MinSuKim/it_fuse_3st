package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.CalculatedValueService;

public class ProductSellInfoTable extends JPanel {
	private JTable table;
	private static CalculatedValueService dao;
	private JLabel lblSum;
	private JTextField lblText;
	private JLabel lblSum1;
	private JLabel lblSum2;
	private JLabel lblSum3;
	private JLabel lblSum4;
	private JLabel lblSum5;
	
	public ProductSellInfoTable() {
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
		loadData();
	}
	public void loadData(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
		cellAlign();
		cellWidth();
		
	}
	public int[] loadSum(){
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByProduct();
		int quantity = 0;
		int sellprice = 0;
		int disprice = 0;
		int marginprice = 0;
		for(int i = 0; i < calculatedValues.size(); i++){
			quantity += calculatedValues.get(i).getSellinfo().getQuantity();
			sellprice += calculatedValues.get(i).getSellprice();
			disprice += calculatedValues.get(i).getDisprice();
			marginprice += calculatedValues.get(i).getMarginprice();
		}
		return new int[]{quantity,sellprice,disprice,marginprice};
	}
	
	
	private void cellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0,1);
		tableCellAlignment(SwingConstants.RIGHT, 2,3,4,5,6);
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
		tableSetWidth(100,120,120,120,120,120,120);
	}
	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
			;// 컬럼모델 생성해서 가운데 정렬 렌더러 넣어줌
		}
	}

	protected String[] getColumn() {
		return new String[]{"거래처코드","거래처명","판매수량","판매금액","할인금액","마진액","마진율"};
	}
	
	protected String[][] getRowDate() {
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByProduct();
		String[][] datas = new String[calculatedValues.size()][];
		for(int i = 0; i < datas.length; i++){
			System.out.println(calculatedValues.get(i));
			datas[i] = calculatedValues.get(i).toArrayforProductSellInfoT();
		}
		return datas;
	}
	public void loadDateByCode(Product pRes) {
		table.setModel(new DefaultTableModel(getRowDate(pRes),getColumn()));
	}
	private Object[][] getRowDate(Product pRes) {
		Map<String, String> item = new HashMap<>();
		item.put("pcode", pRes.getCode());
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByProductByCode(item);
		for(CalculatedValue cv : calculatedValues){
			System.out.println(cv);
		}
		String[][] datas = new String[calculatedValues.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = calculatedValues.get(i).toArrayforProductSellInfoT();
		}
		return datas;
	}
	

}
