package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.ProductTable;

public class ProductConditionPanel extends JPanel {

	
	public ProductConditionPanel() {
		ProductTable pt = new ProductTable();
		add(pt);
	}

}
