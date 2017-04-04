package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class InquiryPanel extends JPanel {


	public InquiryPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		EmployeeConditionPanel pEmpCon = new EmployeeConditionPanel();
		tabbedPane.addTab("영업사원현황", null, pEmpCon, null);
		
		JPanel pProCon = new JPanel();
		tabbedPane.addTab("제품현황", null, pProCon, null);
		
		JPanel pCusCon = new JPanel();
		tabbedPane.addTab("거래처현황", null, pCusCon, null);
		
		
		
	}

}
