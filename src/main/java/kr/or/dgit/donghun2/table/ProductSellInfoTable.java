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

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.service.CalculatedValueService;
import kr.or.dgit.donghun2.service.ProductService;

public class ProductSellInfoTable extends JPanel {
	private JTable table;
	private static CalculatedValueService dao;

	
	public ProductSellInfoTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();

	}
	public void loadData(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
		cellAlign();
		cellWidth();
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
	

}
