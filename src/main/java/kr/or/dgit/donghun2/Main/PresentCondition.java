package kr.or.dgit.donghun2.Main;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PresentCondition extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentCondition frame = new PresentCondition();
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
	public PresentCondition() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("영업사원현황");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("제품현황");
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("거래처현황");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("거래처별 거래 현황");
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("제품별 거래 현황");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("영업별 사원 거래 현황");
		contentPane.add(btnNewButton_1);
	}
}
