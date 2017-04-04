package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.service.CalculatedValueService;

public class CustomerSellInfoTable extends JPanel {
	private JTable table;
	private static CalculatedValueService dao;

	/**
	 * Create the panel.
	 */
	public CustomerSellInfoTable() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		loadDate();
	}

	private void loadDate() {
		table.setModel(new DefaultTableModel(getRowDate(), getColumn()));
	}

	protected String[] getColumn() {
		return new String[]{"거래일자","제품코드","제품명","판매수량","판매금액","할인금액","마진액","마진율"};
	}

	protected String[][] getRowDate() {
		List<CalculatedValue> calculatedValues = dao.getInstance().vw_InfoByCustomer();
		String[][] datas = new String[calculatedValues.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = calculatedValues.get(i).toArrayforCustomerSellInfoT();
		}
		return datas;
	}
	

}























