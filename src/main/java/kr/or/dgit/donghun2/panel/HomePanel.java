package kr.or.dgit.donghun2.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	
	private JButton pBackup;
	private JButton pInit;
	private JButton pRestore;
	
	public HomePanel() {
		JPanel panel = new JPanel();
		add(panel);
		pBackup = new JButton("백업");
		pInit = new JButton("초기화");
		pRestore = new JButton("복원");
		panel.add(pInit);
		panel.add(pBackup);
		panel.add(pRestore);
		
	}

}
