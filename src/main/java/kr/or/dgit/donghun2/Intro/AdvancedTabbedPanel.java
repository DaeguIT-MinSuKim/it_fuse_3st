package kr.or.dgit.donghun2.Intro;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.donghun2.EmployeeChart.EmployeeChartPanel;
import kr.or.dgit.donghun2.SellInfo.SellInfoTabbedPanel;

public class AdvancedTabbedPanel extends JTabbedPane implements ChangeListener{

	private SellInfoTabbedPanel pSellInfoTabbedPanel;
	private JPanel pSellInfo;
	private EmployeeChartPanel pECP;
	/**
	 * Create the panel.
	 */
	public AdvancedTabbedPanel() {
		addChangeListener(this);
		pSellInfo = new JPanel();
		pSellInfoTabbedPanel = new SellInfoTabbedPanel();
		
		addTab("거래내역관리", null, pSellInfo, null);
		pSellInfo.setLayout(new BoxLayout(pSellInfo, BoxLayout.Y_AXIS));
		pSellInfoTabbedPanel.setLayout(new BoxLayout(pSellInfoTabbedPanel, BoxLayout.Y_AXIS));
			if(pSellInfoTabbedPanel !=null){
				pSellInfo.removeAll();
			}
		pSellInfo.add(pSellInfoTabbedPanel);
		
		pECP = new EmployeeChartPanel();
		addTab("영업사원 별 거래내역 차트", null, pECP, null);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

		
	

}
