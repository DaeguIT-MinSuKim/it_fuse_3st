package kr.or.dgit.donghun2.Product;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.ProductConditionTable;

public class ProductConditionPanel extends JPanel {

	
	public ProductConditionPanel() {
		ProductConditionTable pt = new ProductConditionTable();
		add(pt);
	}

}
