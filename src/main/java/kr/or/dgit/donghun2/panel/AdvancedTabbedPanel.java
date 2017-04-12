package kr.or.dgit.donghun2.panel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class AdvancedTabbedPanel extends JPanel {

	private SellInfoTabbedPanel pSellInfo;

	/**
	 * Create the panel.
	 */
	public AdvancedTabbedPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		pSellInfo = new SellInfoTabbedPanel();
		tabbedPane.addTab("거래내역등록", null, pSellInfo, null);
		pSellInfo.setLayout(new BoxLayout(pSellInfo, BoxLayout.Y_AXIS));

	}

}
