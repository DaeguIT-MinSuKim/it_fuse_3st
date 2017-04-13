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

import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.ProductService;

public class ProductConditionTable extends JPanel {
	private JTable table;
	private static ProductService dao;

	public ProductConditionTable() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();

	}

	public void loadData() {
		table.setModel(new DefaultTableModel(getRowDate(), getColumn()));
		cellAlign();
		cellWidth();
	}

	private void cellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1);
		tableCellAlignment(SwingConstants.RIGHT, 2, 3);
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
		tableSetWidth(100, 120, 120, 120);
	}

	private void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
			;// 컬럼모델 생성해서 가운데 정렬 렌더러 넣어줌
		}
	}

	protected String[] getColumn() {
		return new String[] { "제품코드", "제품명", "판매정가", "판매원가" };
	}

	protected String[][] getRowDate() {
		List<Product> products = dao.getInstance().selectProductByAll();
		for(int i=products.size()-1; i>=0;i--){
			if(products.get(i).isIsexist()==false){
				products.remove(i);
			}
		}
		
		String[][] datas = new String[products.size()][];
		for (int i = 0; i < datas.length; i++) {
			if (products.get(i).isIsexist()) {
				
				datas[i] = products.get(i).toArray();
				System.out.println(datas[i]);
			}
		}
		return datas;
	}

}
