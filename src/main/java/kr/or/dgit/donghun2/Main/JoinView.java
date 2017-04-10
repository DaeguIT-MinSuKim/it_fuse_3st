package kr.or.dgit.donghun2.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.panel.JoinPanel;
import kr.or.dgit.donghun2.panel.LoginPanel;
import kr.or.dgit.donghun2.service.LoginService;

public class JoinView extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel pMemberJoin;
	private JoinPanel pJoin;
	private JPanel pBtn;
	private JButton btnJoin;
	private JButton btnBack;
	private LoginService dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinView frame = new JoinView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JoinView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		add(panel);
		pMemberJoin = new JPanel();
		panel.add(pMemberJoin);
		pMemberJoin.setLayout(new GridLayout(0,1,10,10));
		
		pJoin = new JoinPanel();		
		pMemberJoin.add(pJoin);
		pBtn = new JPanel();
		pMemberJoin.add(pBtn);
		
		btnJoin = new JButton("가입하기");
		btnJoin.addActionListener(this);
		btnBack = new JButton("가입 취소하기");
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
		setVisible(false);
	}
}
