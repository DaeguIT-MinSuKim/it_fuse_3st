package kr.or.dgit.donghun2.Main;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.view.CustomerView;
import kr.or.dgit.donghun2.view.EmployeeView;
import kr.or.dgit.donghun2.view.ProductView;

public class Basic extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Basic frame = new Basic();
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
	public Basic() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 400, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("영업사원관리");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("제품관리");
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("거래처관리");
		btnNewButton_2.addActionListener(this);
		contentPane.add(btnNewButton_2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(e);
		}
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		EmployeeView ev = new EmployeeView();
		ev.setVisible(true);
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		ProductView pv = new ProductView();
		pv.setVisible(true);
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		CustomerView cv = new CustomerView();
		cv.setVisible(true);
	}
}
