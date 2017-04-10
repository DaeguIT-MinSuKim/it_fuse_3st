package kr.or.dgit.donghun2.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JPasswordField;

import erp_myframework.CompPane;

public class PasswordPanel extends JPanel {
	private JPasswordField passwordField;
	private CompPane pValue;

	
	public PasswordPanel() {
		pValue = new CompPane();
		pValue.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		add(pValue);
		
		passwordField = new JPasswordField();
		pValue.add(passwordField);

	}
	/*public String getpwValue(){
		return passwordField;
	}
*/
}
