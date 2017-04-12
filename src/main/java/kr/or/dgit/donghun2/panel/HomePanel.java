package kr.or.dgit.donghun2.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.initSetting.InitSettingService;

public class HomePanel extends JPanel implements ActionListener{
	
	private JButton bBackup;
	private JButton bInit;
	private JButton bRestore;
	private InitSettingService initSettingService;
	
	public HomePanel() {
		JPanel panel = new JPanel();
		add(panel);
		bBackup = new JButton("백업");
		bBackup.addActionListener(this);
		bInit = new JButton("초기화");
		bInit.addActionListener(this);
		bRestore = new JButton("복원");
		bRestore.addActionListener(this);
		panel.add(bInit);
		panel.add(bBackup);
		panel.add(bRestore);
		initSettingService = new InitSettingService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bInit) {
			actionPerformedBtnInitSet(e);
			}
		if (e.getSource() == bRestore) {
			actionPerformedBtnRestore(e);
		}

		if (e.getSource() == bBackup) {
			actionPerformedBtnBackup(e);
			}
	}

	private void actionPerformedBtnBackup(ActionEvent e) {
		initSettingService.initSetting(0, 0);
		System.out.println("백업");
	}

	private void actionPerformedBtnRestore(ActionEvent e) {
		initSettingService.initSetting(1, 1);
		System.out.println("복원");
	}

	private void actionPerformedBtnInitSet(ActionEvent e) {
		initSettingService.initSetting(0, 1);
		System.out.println("초기화");
	}

}
