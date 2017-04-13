package kr.or.dgit.donghun2.product;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.ProductConditionTable;

public class ProductConditionPanel extends JPanel {

	
	public ProductConditionPanel() {
		ProductConditionTable pt = new ProductConditionTable();
		add(pt);
	}

}
