package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.Main.JoinView;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.PlatformLoggingMXBean;

public class LoginPanel extends JPanel implements ActionListener{

	
	private TextFiledPanel pID;
	private TextFiledPanel pPassword;

	private JPanel pLogin;
	private LoginBtnPanel pLBP;
	private JPanel panel;

	public LoginPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		panel = new JPanel();
		add(panel);
		
		pLogin = new JPanel();
		panel.add(pLogin);
		pLogin.setLayout(new GridLayout(0, 1, 0, 10));
				
		pID = new TextFiledPanel();
		pID.setTitle("  아  이  디          ");
		pLogin.add(pID);
		pID.setLayout(new BoxLayout(pID, BoxLayout.X_AXIS));
		
		pPassword = new TextFiledPanel();
		pPassword.setTitle("  비  밀  번  호    ");
		pLogin.add(pPassword);
		pPassword.setLayout(new BoxLayout(pPassword, BoxLayout.X_AXIS));
		
		
		pLBP = new LoginBtnPanel();
		pLogin.add(pLBP);
		pLBP.getbJoin().addActionListener(this);
		
		/*pbtn = new JPanel();
		pLogin.add(pbtn);
		bJoin = new JButton("회원가입");
		bLogin = new JButton("로그인");
		bSearch = new JButton("아이디/비밀번호 찾기");

		pbtn.add(bLogin);
		pbtn.add(bJoin);
		bJoin.addActionListener(this);
		pbtn.add(bSearch);*/

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pLBP.getbJoin()){
			actionPerformedbJoin(e);
		}
	}

	private void actionPerformedbJoin(ActionEvent e) {
		JoinView jv = new JoinView();
		jv.setVisible(true);
	}
	
	
	
}
