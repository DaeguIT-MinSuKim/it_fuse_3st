package kr.or.dgit.donghun2.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LoginBtnPanel extends JPanel{

	private JPanel pBtn;
	private JButton bLogin;
	private JButton bJoin;
	private JButton bSearch;

	public LoginBtnPanel() {
		pBtn = new JPanel();
		add(pBtn);
		bLogin = new JButton("로그인");
		bJoin = new JButton("회원가입");
		bSearch = new JButton("아이디/비밀번호 찾기");
		pBtn.add(bLogin);
		pBtn.add(bJoin);
		pBtn.add(bSearch);
	}
	public JButton getbLogin(){
		return bLogin;
	}
	public JButton getbJoin(){
		return bJoin;
	}
	public JButton getbSearch(){
		return bSearch;
	}
}
