package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.Intro.JoinPanel;
import kr.or.dgit.donghun2.service.LoginService;

public class JoinView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pMemberJoin;
	private JoinPanel pJoin;
	private JPanel pBtn;
	private JButton btnJoin;
	private JButton btnBack;
	private LoginService dao;

	

	public JoinView() {
		setTitle("사원등록");
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
		pMemberJoin.setLayout(new GridLayout(0, 1, 10, 10));

		pJoin = new JoinPanel();
		pMemberJoin.add(pJoin);
		pBtn = new JPanel();
		pMemberJoin.add(pBtn);

		btnJoin = new JButton("가입하기");
		btnJoin.addActionListener(this);
		btnBack = new JButton("취소");
		btnBack.addActionListener(this);
		pBtn.add(btnJoin);
		pBtn.add(btnBack);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBack) {
			actionPerformedbBack(e);
		}
		if (e.getSource() == btnJoin) {
			actionPerformedbJoin(e);
		}
	}

	private void actionPerformedbJoin(ActionEvent e) {
		if (pJoin.isEmptyCheck()) {
			JOptionPane.showMessageDialog(null, "빈 칸이 있습니다.");
			return;
		} else if (checkId() == false) {
			JOptionPane.showMessageDialog(null, "정확하게 아이디를 입력하세요.");
			return;
		} else if (checkPw() == false) {
			JOptionPane.showMessageDialog(null, "첫글자는 영어 대소문자, 6자리 이상 16자리 이하로 입력해주세요.");
			return;
		} else if (pJoin.isPasswordEquls() == false) {
			JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.");
			return;

		} else if (checkEmail() == false) {
			JOptionPane.showMessageDialog(null, "이메일을 정확히 입력하세요.");
			return;
		} else {
			dao.getInstance().insertLogin(pJoin.getObject());
			JOptionPane.showMessageDialog(null, "가입되었습니다.");
			setVisible(false);
		}
	}

	private void actionPerformedbBack(ActionEvent e) {
		setVisible(false);
	}

	private boolean checkPw() {
		String data = pJoin.getpPassword().getText();
		String pwReg = "^[a-zA-Z]{1}[a-zA-Z0-9]{6,16}$";
		return Pattern.matches(pwReg, data);
	}

	private boolean checkId() {
		String data = pJoin.getpID().getTfValue();
		String idReg = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
		return Pattern.matches(idReg, data);
	}

	private boolean checkEmail() {
		String data = pJoin.getpEmail().getTfValue();
		String emailReg = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		return Pattern.matches(emailReg, data);
	}
}
