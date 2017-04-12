package kr.or.dgit.donghun2.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.dto.Employee;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.initSetting.InitSettingService;
import kr.or.dgit.donghun2.service.EmployeeService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class TestMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRestore;
	private JButton btnBackup;
	private JButton btnInitSet;

	private InitSettingService initSettingService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestMain frame = new TestMain();
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
	public TestMain() {
		testInit();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		btnInitSet = new JButton("초기화");
		btnInitSet.addActionListener(this);
		panel.add(btnInitSet);
		
		
		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		panel.add(btnBackup);
		
		
		
		
		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		panel.add(btnRestore);
		
		initSettingService = new InitSettingService();
		 
	}

	private void testInit() {

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInitSet) {
			actionPerformedBtnInitSet(e);
			}
		if (e.getSource() == btnRestore) {
			actionPerformedBtnRestore(e);
		}

		if (e.getSource() == btnBackup) {
			actionPerformedBtnBackup(e);
			}
	}

	private void actionPerformedBtnInitSet(ActionEvent e) {
		initSettingService.initSetting(0, 1);
		System.out.println("초기화");
		
	}

	private void actionPerformedBtnBackup(ActionEvent e) {
		initSettingService.initSetting(0, 0);
		System.out.println("백업");
	}

	private void actionPerformedBtnRestore(ActionEvent e) {
		initSettingService.initSetting(1, 1);
		System.out.println("복원");
	}

}
