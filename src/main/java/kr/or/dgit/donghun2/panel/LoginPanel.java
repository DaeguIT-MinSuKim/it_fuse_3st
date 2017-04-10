package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class LoginPanel extends JPanel {

	
	private TextFiledPanel pID;
	private TextFiledPanel pPassword;
	private JPanel pbtn;
	private JButton bJoin;
	private JButton bLogin;
	private JButton bSearch;

	public LoginPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		pID = new TextFiledPanel();
		pID.setTitle("아이디      ");
		panel_2.add(pID);
		pID.setLayout(new BoxLayout(pID, BoxLayout.X_AXIS));
		
		pPassword = new TextFiledPanel();
		pPassword.setTitle("비밀번호  ");
		panel_2.add(pPassword);
		pPassword.setLayout(new BoxLayout(pPassword, BoxLayout.X_AXIS));
		
		pbtn = new JPanel();
		panel_2.add(pbtn);
		bJoin = new JButton("회원가입");
		bLogin = new JButton("로그인");
		bSearch = new JButton("아이디/비밀번호 찾기");

		pbtn.add(bLogin);
		pbtn.add(bJoin);
		pbtn.add(bSearch);

	}

}
