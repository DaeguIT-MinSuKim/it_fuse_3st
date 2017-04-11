package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import kr.or.dgit.donghun2.table.ProductConditionTable;
import kr.or.dgit.donghun2.table.ProductTable;

public class ProductConditionPanel extends JPanel {

	
	public ProductConditionPanel() {
		ProductConditionTable pt = new ProductConditionTable();
		add(pt);
	}

}
