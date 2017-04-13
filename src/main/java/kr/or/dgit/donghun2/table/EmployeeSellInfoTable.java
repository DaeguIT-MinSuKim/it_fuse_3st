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
import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.service.CalculatedValueService;

public class EmployeeSellInfoTable extends JPanel {
	private JTable table;
	private JLabel lblSum;
	private JLabel lblSum1;
	private JLabel lblSum2;
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
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		
		lblSum = new JLabel("합계");
		lblSum1 = new JLabel("판매 금액");
		lblSum2 = new JLabel("마진액");
		
		panel.add(lblSum);
		lblSum.setText("합계                   ");
		panel.add(lblSum1);
		lblSum1.setText("      판매 금액    "+String.format("%,d",loadSum()[0]));
		panel.add(lblSum2);
		lblSum2.setText("      마진액    "+String.format("%,d", loadSum()[1]));
		loadDate();
		

	}
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
		cellAlign();
		cellWidth();
	}
	
	protected String[] getColumn() {
		return new String[]{"사원코드","사원명","거래일자","판매금액","마진액","마진율"};
	}
	
	public void loadDateByCode(Employee eRes) {
		table.setModel(new DefaultTableModel(getRowDate(eRes),getColumn()));
	}
	public void loadDateByAll(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
		cellAlign();
		cellWidth();
	}
	public int[] loadSum(){
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByEmployee();
		int sellprice=0;
		int marginprice=0;
		for(int i = 0; i < calculatedValues.size(); i++){
			sellprice += calculatedValues.get(i).getSellprice();
			marginprice += calculatedValues.get(i).getMarginprice();
		}
		return new int[]{sellprice,marginprice};

	}
	
	private void cellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1,2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5);
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
		tableSetWidth(100, 120, 120, 120, 120,120);
	}

	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
			;// 컬럼모델 생성해서 가운데 정렬 렌더러 넣어줌
		}
	}
	
	
	
	
	private String[][] getRowDate(Employee eRes) {
		Map<String, String> item = new HashMap<>();
		item.put("ecode", eRes.getCode());
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByEmployeeByCode(item);
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
