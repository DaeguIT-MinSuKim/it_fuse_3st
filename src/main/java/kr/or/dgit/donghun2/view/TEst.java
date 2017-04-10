package kr.or.dgit.donghun2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.donghun2.panel.BasicTabbedPanel;
import kr.or.dgit.donghun2.panel.LoginPanel;

public class TEst extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEst frame = new TEst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TEst() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		LoginPanel login = new LoginPanel();
		contentPane.add(login, BorderLayout.CENTER);
		
		JPanel panel= new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel1= new JPanel();
		contentPane.add(panel1, BorderLayout.SOUTH);
		JPanel panel2= new JPanel();
		contentPane.add(panel2, BorderLayout.EAST);
		JPanel panel3= new JPanel();
		contentPane.add(panel3, BorderLayout.WEST);
		
		
	}

}
