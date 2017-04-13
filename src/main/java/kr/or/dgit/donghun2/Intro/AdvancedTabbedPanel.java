package kr.or.dgit.donghun2.Intro;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.donghun2.customerChart.CustomerChartPanel;
import kr.or.dgit.donghun2.employeeChart.EmployeeChartPanel;
import kr.or.dgit.donghun2.productChart.ProductChartPanel;
import kr.or.dgit.donghun2.sellInfo.SellInfoTabbedPanel;

public class AdvancedTabbedPanel extends JTabbedPane implements ChangeListener{

	private SellInfoTabbedPanel pSellInfoTabbedPanel;
	private JPanel pSellInfo;
	private JPanel pECP;
	private JPanel pPCP;
	private JPanel pCCP;
	private EmployeeChartPanel pECPTabbedPanel;
	private ProductChartPanel pPCPTabbedPanel;
	private CustomerChartPanel pCCPTabbedPanel;
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
		
		pECP = new JPanel();
		addTab("영업사원 별 거래내역 현황 차트", null, pECP, null);
		
		pPCP = new JPanel();
		addTab("제품 별 거래내역 현황 차트", null, pPCP, null);
		
		pCCP = new JPanel();
		addTab("거래처 별 거래내역 현황 차트", null,pCCP, null);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==this){
			stateChangedThis(this.getSelectedIndex());
		}
	}

	private void stateChangedThis(int selectedIndex) {
		if(this.getTitleAt(selectedIndex).equals("영업사원등록")){
			pSellInfo.setLayout(new BoxLayout(pSellInfo, BoxLayout.Y_AXIS));
			if(pSellInfoTabbedPanel != null){
				pSellInfo.removeAll();
			}
			pSellInfoTabbedPanel = new SellInfoTabbedPanel();
			pSellInfo.add(pSellInfoTabbedPanel);
		} else if(this.getTitleAt(selectedIndex).equals("영업사원 별 거래내역 현황 차트")){
			pECP.setLayout(new BoxLayout(pECP, BoxLayout.Y_AXIS));
			if(pECPTabbedPanel != null){
				pPCP.removeAll();
			}
			pECPTabbedPanel = new EmployeeChartPanel();
			pECP.add(pECPTabbedPanel);
		}  else if(this.getTitleAt(selectedIndex).equals("제품 별 거래내역 현황 차트")){
			pPCP.setLayout(new BoxLayout(pPCP, BoxLayout.Y_AXIS));
			if(pPCPTabbedPanel != null){
				pPCP.removeAll();
			}
			pPCPTabbedPanel = new ProductChartPanel();
			pPCP.add(pPCPTabbedPanel);
		}  else if(this.getTitleAt(selectedIndex).equals("거래처 별 거래내역 현황 차트")){
			pCCP.setLayout(new BoxLayout(pCCP, BoxLayout.Y_AXIS));
			if(pCCPTabbedPanel != null){
				pCCP.removeAll();
			}
			pCCPTabbedPanel = new CustomerChartPanel();
			pCCP.add(pCCPTabbedPanel);
		} 
	}

		
	

}
