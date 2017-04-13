package kr.or.dgit.donghun2.Intro;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.donghun2.CustomerChart.CustomerChartPanel;
import kr.or.dgit.donghun2.EmployeeChart.EmployeeChartPanel;
import kr.or.dgit.donghun2.ProductChart.ProductChartPanel;
import kr.or.dgit.donghun2.SellInfo.SellInfoTabbedPanel;

public class UnitAdvancedTabbedPanel extends JTabbedPane implements ChangeListener{

	private SellInfoTabbedPanel pSellInfoTabbedPanel;
	private JPanel pSellInfo;
	private EmployeeChartPanel pECP;
	private ProductChartPanel pPCP;
	private CustomerChartPanel pCCP;
	/**
	 * Create the panel.
	 */
	public UnitAdvancedTabbedPanel() {
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
		addTab("영업사원 별 거래내역 현황 차트", null, pECP, null);
		
		pPCP = new ProductChartPanel();
		addTab("제품 별 거래내역 현황 차트", null, pPCP, null);
		
		pCCP = new CustomerChartPanel();
		addTab("거래처 별 거래내역 현황 차트", null,pCCP, null);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

		
	

}
