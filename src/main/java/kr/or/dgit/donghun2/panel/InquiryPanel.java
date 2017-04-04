package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kr.or.dgit.donghun2.table.ProductTable;

import java.awt.BorderLayout;

public class InquiryPanel extends JPanel {


	public InquiryPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		EmployeeConditionPanel pEmpCon = new EmployeeConditionPanel();
		tabbedPane.addTab("영업사원현황", null, pEmpCon, null);
		
		ProductTable pProCon = new ProductTable();
		tabbedPane.addTab("제품현황", null, pProCon, null);
		
		CustomerConditionPanel pCusCon = new CustomerConditionPanel();
		tabbedPane.addTab("거래처현황", null, pCusCon, null);
		
		
		
	}

}
