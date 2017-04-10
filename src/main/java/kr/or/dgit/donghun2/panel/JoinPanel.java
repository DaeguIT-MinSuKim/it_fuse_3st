package kr.or.dgit.donghun2.panel;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Login;

public class JoinPanel extends JPanel{

	
	private JPanel pJoin;
	private TextFiledPanel pID;
	private TextFiledPanel pPassword;
	private TextFiledPanel pPasswordRe;
	private TextFiledPanel pEmail;

	public JoinPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pJoin = new JPanel();
		add(pJoin);
		pJoin.setLayout(new GridLayout(0, 1,0,10));
		
		pID = new TextFiledPanel();
		pID.setTitle("아이디");
		pJoin.add(pID);
		
		pPassword = new TextFiledPanel();
		pPassword.setTitle("비밀번호");
		pJoin.add(pPassword);
		
		pPasswordRe = new TextFiledPanel();
		pPasswordRe.setTitle("비밀번호확인");
		pJoin.add(pPasswordRe);
		
		pEmail = new TextFiledPanel();
		pEmail.setTitle("email");
		pJoin.add(pEmail);
	}
	
	
	public TextFiledPanel getpID() {
		return pID;
	}
	public TextFiledPanel getpPassword() {
		return pPassword;
	}
	public TextFiledPanel getpPasswordRe() {
		return pPasswordRe;
	}


	public Login getObject(){
		String ID = pID.getTfValue();
		String password = pPassword.getTfValue();
		String passwordre = pPasswordRe.getTfValue();
		String email = pEmail.getTfValue();
		return new Login(ID, password, passwordre, email);
	}
	
	public void setObject(Login item){
		pID.setTfValue(item.getId());
		pPassword.setTfValue(item.getPassword());
		pEmail.setTfValue(item.getEmail());
	}
	
	public void clear(){
		pID.setTfValue("");
		pPassword.setTfValue("");
		pPasswordRe.setTfValue("");
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
