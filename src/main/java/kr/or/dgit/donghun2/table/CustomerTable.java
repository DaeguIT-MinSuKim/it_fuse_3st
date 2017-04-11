package kr.or.dgit.donghun2.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.donghun2.dto.Customer;
import kr.or.dgit.donghun2.service.CustomerService;

public class CustomerTable extends JPanel {
	private JTable table;
	private static CustomerService dao;

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

	public void loadDate() {
		table.setModel(new DefaultTableModel(getRowDate(), getColumn()));
		cellAlign();
		cellWidth();
	}

	private void cellWidth() {
		tableSetWidth(100, 120, 120);
	}

	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
			;// 컬럼모델 생성해서 가운데 정렬 렌더러 넣어줌
		}
	}

	private void cellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
	}

	private void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
	}
	
	

	protected String[] getColumn() {
		return new String[] { "거래처코드", "거래처명", "거래처등급" };
	}

	protected String[][] getRowDate() {
		List<Customer> customers = dao.getInstance().selectCustomerByAllDesc();
		for (int i = customers.size()-1; i >= 0; i--) {
			if (customers.get(i).isIsexist() == false) {
				customers.remove(i);
			}
		}
		String[][] datas = new String[customers.size()][];
		for (int i = 0; i < datas.length; i++) {
				datas[i] = customers.get(i).toArray();
		}
		return datas;
	}
	
	
}
