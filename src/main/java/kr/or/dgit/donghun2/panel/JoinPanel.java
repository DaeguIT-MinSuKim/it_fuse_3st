package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class JoinPanel extends JPanel implements ActionListener{

	
	private JPanel pJoin;
	private TextFiledPanel pID;
	private TextFiledPanel pPassword;
	private TextFiledPanel pPasswordRe;
	private JPanel pBtn;
	private JButton bJoin;
	private JButton bBack;

	public JoinPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pJoin = new JPanel();
		add(pJoin);
		pJoin.setLayout(new BoxLayout(pJoin, BoxLayout.Y_AXIS));
		
		pID = new TextFiledPanel();
		pJoin.add(pID);
		
		pPassword = new TextFiledPanel();
		pJoin.add(pPassword);
		
		pPasswordRe = new TextFiledPanel();
		pJoin.add(pPasswordRe);
		
		pBtn = new JPanel();
		pJoin.add(pBtn);
		
		bJoin = new JButton("가입하기");
		pBtn.add(bJoin);
		
		bBack = new JButton("뒤로가기");
		pBtn.add(bBack);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	

}
