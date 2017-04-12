package kr.or.dgit.donghun2.Main;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Login;
import kr.or.dgit.donghun2.service.LoginService;

public class MainProcess extends JFrame {
	MainFrame mainFrame;
	UserFrame userFrame;
	private JTextField userText;
	private JPasswordField passText;
	private JButton btnInit;
	private JButton btnSave;
	private JButton btnLogin;
	private JLabel userLabel;
	private JLabel passLabel;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

		} catch (Exception e) {
		}
		MainProcess lv = new MainProcess();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainProcess frame = new MainProcess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public MainProcess() {
		// setting
		setTitle("login");
		setSize(280, 150);
		setResizable(false);
		setLocation(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// panel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);

		// add
		add(panel);

	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		passLabel = new JLabel("Pass");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);
		passText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});

		btnInit = new JButton("Reset");
		btnInit.setBounds(9, 80, 85, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passText.setText("");
			}
		});
		btnSave = new JButton("SignIn");
		btnSave.setBounds(93, 80, 85, 25);
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinView jv = new JoinView();
				jv.setVisible(true);
			}

		});

		btnLogin = new JButton("Login");
		btnLogin.setBounds(177, 80, 85, 25);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});

	}

	public void isLoginCheck() {
		if (userText.getText().equals("") || passText.getUIClassID().equals("")) { // 공백확인
			JOptionPane.showMessageDialog(null, "공백이 있습니다.");
			return;
		} else { // 공백이 아니면?
			Login isGrade = LoginService.getInstance().selectLoginByGrade(new Login(userText.getText(), null));
			Login Ls = LoginService.getInstance()
					.selectLoginById(new Login(userText.getText(), String.valueOf(passText.getPassword())));
			if (Ls != null) { // ID 확인
				if (isGrade.getGrade()) {
					JOptionPane.showMessageDialog(null, "Success");
					showMainFrame();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Success");
					showUserFrame();
					setVisible(false);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Faild");
				clear();
			}
		}
	}




	public void showMainFrame() {
		this.mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}

	public void showUserFrame() {
		this.userFrame = new UserFrame();
		userFrame.setVisible(true);
	}

	public boolean isEmptyCheck() {
		boolean result = false;
		for (Component c : getComponents()) {
			if (c instanceof TextFiledPanel) {
				TextFiledPanel tfp = (TextFiledPanel) c;
				if (tfp.isEmpty()) {
					return true;
				}
			}
		}
		return false;

	}

	public void clear() {
		userText.setText("");
		passText.setText("");
	}

}
