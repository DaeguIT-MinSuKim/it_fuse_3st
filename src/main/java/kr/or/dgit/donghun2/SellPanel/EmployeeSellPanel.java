package kr.or.dgit.donghun2.SellPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;

public class EmployeeSellPanel extends JPanel implements ActionListener {
	private JButton btnConfirm;
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private TextFiledPanel pGrade;

	
	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public EmployeeSellPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("사원코드");
		add(pCode);
		
		JPanel pBtn = new JPanel();
		add(pBtn);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.X_AXIS));
		pBtn.add(btnConfirm);
		
		pName = new TextFiledPanel();
		pName.setTitle("사원명");
		add(pName);
		
		pGrade = new TextFiledPanel();
		pGrade.setTitle("사원등급");
		add(pGrade);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
