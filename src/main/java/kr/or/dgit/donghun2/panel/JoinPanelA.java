package kr.or.dgit.donghun2.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.donghun2.service.LoginService;

public class JoinPanelA extends JPanel implements ActionListener{

	private JoinPanel pJoin;
	private JPanel pBtn;
	private JButton btnJoin;
	private JButton btnBack;
	private JPanel pMemberJoin;
	private LoginService dao;
	
	public JoinPanelA() {
		pMemberJoin = new JPanel();
		add(pMemberJoin);
		pMemberJoin.setLayout(new GridLayout(0,1,10,10));
		
		pJoin = new JoinPanel();		
		pMemberJoin.add(pJoin);
		pBtn = new JPanel();
		pMemberJoin.add(pBtn);
		
		btnJoin = new JButton("가입하기");
		btnJoin.addActionListener(this);
		btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(this);
		pBtn.add(btnJoin);
		pBtn.add(btnBack);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBack){
			actionPerformedbBack(e);
		}
		if(e.getSource() == btnJoin){
			actionPerformedbJoin(e);
		}
	}

	private void actionPerformedbJoin(ActionEvent e) {
		if(pJoin.isEmpty()){
			JOptionPane.showMessageDialog(null, "빈 칸이 있습니다.");
			System.out.println("####");
		}else if(pJoin.getObject().getPassword()!=pJoin.getObject().getPasswordRe()){
			JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요");
			System.out.println("####%%");
		}else{
			dao.getInstance().insertLogin(pJoin.getObject());
			JOptionPane.showMessageDialog(null, "가입되었습니다.");
		}
	}

	private void actionPerformedbBack(ActionEvent e) {
		pMemberJoin.removeAll();
		pMemberJoin.add(new LoginPanel());
		revalidate();
		repaint();
	}
	
}
