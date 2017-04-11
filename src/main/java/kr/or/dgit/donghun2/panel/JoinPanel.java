package kr.or.dgit.donghun2.panel;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Login;


public class JoinPanel extends JPanel{

	
	private JPanel pJoin;
	private TextFiledPanel pID;
	
	private JPasswordField pPassword;
	private JPasswordField pPasswordRe;
	private TextFiledPanel pEmail;

	public JoinPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pJoin = new JPanel();
		add(pJoin);
		pJoin.setLayout(new GridLayout(0, 1,0,10));
		
		pID = new TextFiledPanel();
		pID.setTitle("아이디");
		pJoin.add(pID);
		
		pPassword = new JPasswordField();
		pJoin.add(pPassword);
		
		pPasswordRe = new JPasswordField();
		pJoin.add(pPasswordRe);
		
		pEmail = new TextFiledPanel();
		pEmail.setTitle("email");
		pJoin.add(pEmail);
	}
	
	
	public TextFiledPanel getpID() {
		return pID;
	}
	
	public JPasswordField getpPassword() {
		return pPassword;
	}
	public JPasswordField getpPasswordRe() {
		return pPasswordRe;
	}


	public Login getObject(){
		String ID = pID.getTfValue();
		String password = pPassword.getText();
		String passwordRe = pPasswordRe.getText();
		String email = pEmail.getTfValue();
		return new Login(ID, password,passwordRe, email);
	}
	
	public void setObject(Login item){
		pID.setTfValue(item.getId());
		pPassword.setText(item.getPassword());
		pEmail.setTfValue(item.getEmail());
	}
	
	
	public boolean isPasswordEquls(){
		if(pPassword.getText().equals(pPasswordRe.getText()))
			return true;
		return false;
	}
	public boolean isIdEquls(){
		if(pID.getTfValue().equals(pID.getTfValue()))
			return true;
		return false;
	}
	public void clear(){
		pID.setTfValue("");
		pPassword.setText("");
		pPasswordRe.setText("");
		pEmail.setTfValue("");
	}
	public boolean isEmpty(){
		boolean result = false;
		for(Component c : getComponents()){
			if(c instanceof TextFiledPanel){
				TextFiledPanel tfp =(TextFiledPanel)c;
				if(tfp.isEmpty()){
					return true;
				}
			}
		}
		return false;
	}
	

	
	

}
