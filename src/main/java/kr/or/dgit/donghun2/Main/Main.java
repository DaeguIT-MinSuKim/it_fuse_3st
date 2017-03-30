package kr.or.dgit.donghun2.Main;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.view.CustomerView;
import kr.or.dgit.donghun2.view.SellInfoView;

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
			 UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			 
			}catch (Exception e) {}
			CustomerView cv = new CustomerView();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("기초자료관리");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("판매관리");
		btnNewButton_2.addActionListener(this);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("조회업무");
		contentPane.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Basic ba = new Basic();
		ba.setVisible(true);
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		SellInfoView siv = new SellInfoView();
		siv.setVisible(true);
	}
}
