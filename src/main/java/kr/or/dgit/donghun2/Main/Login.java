package kr.or.dgit.donghun2.Main;

import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Login extends JPanel {

	
	private TextFiledPanel panel_6;
	private JPanel panel_7;

	public Login() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		panel_6 = new TextFiledPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		panel_7 = new TextFiledPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.WEST);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.EAST);

	}

}
