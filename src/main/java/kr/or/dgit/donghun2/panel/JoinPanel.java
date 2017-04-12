package kr.or.dgit.donghun2.panel;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import erp_myframework.RadioPanel;
import erp_myframework.TextFiledPanel;
import kr.or.dgit.donghun2.dto.Login;
import javax.swing.SwingConstants;


public class JoinPanel extends JPanel{

	
	private JPanel pJoin;
	private TextFiledPanel pID;
	private JPasswordField pPassword;
	private JPasswordField pPasswordRe;
	private TextFiledPanel pEmail;
	private RadioPanel pGrade;

	public JoinPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pJoin = new JPanel();
		add(pJoin);
		pJoin.setLayout(new GridLayout(0, 1,0,10));
		
		JPanel panel = new JPanel();
		
		pID = new TextFiledPanel();
		pID.setTitle("아이디");
		panel.setLayout(new GridLayout(0, 1));
		pJoin.add(panel);
		panel.add(pID);
		
		JPanel panel2 = new JPanel();
		JLabel lPassword = new JLabel("비밀번호");
		lPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		pJoin.add(panel2);
		panel2.add(lPassword);
		pPassword = new JPasswordField();
		GridLayout gl_panel2 = new GridLayout(0, 2);
		gl_panel2.setHgap(10);
		panel2.setLayout(gl_panel2);
		panel2.add(pPassword);
		
		
		pPasswordRe = new JPasswordField();
		JPanel panel3 = new JPanel();
		
		JLabel lPassword2 = new JLabel("비밀번호 확인");
		lPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridLayout gl_panel3 = new GridLayout(0, 2);
		gl_panel3.setHgap(10);
		panel3.setLayout(gl_panel3);
		pJoin.add(panel3);
		panel3.add(lPassword2);
		panel3.add(pPasswordRe);
		
		JPanel panel4 = new JPanel();
		pJoin.add(panel4);
		pGrade = new RadioPanel();
		pGrade.setTitle("등급");
		panel4.add(pGrade);
		pGrade.setRadioItem("관리자","일반");
		
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
	

	public void setpID(TextFiledPanel pID) {
		this.pID = pID;
	}


	public void setpPassword(JPasswordField pPassword) {
		this.pPassword = pPassword;
	}


	public void setpEmail(TextFiledPanel pEmail) {
		this.pEmail = pEmail;
	}


	public TextFiledPanel getpEmail() {
		return pEmail;
	}

	public Login getObject(){
		String ID = pID.getTfValue();
		String password = pPassword.getText();
		String passwordRe = pPasswordRe.getText();
		String email = pEmail.getTfValue();
		boolean grade = pGrade.getSelectedItem().equals("관리자")?true:false;
		return new Login(ID, password,passwordRe, email,grade);
	}
	
	public void setObject(Login item){
		pID.setTfValue(item.getId());
		pPassword.setText(item.getPassword());
		pEmail.setTfValue(item.getEmail());
		pGrade.setSelectedItem(item.getGrade()?"관리자":"일반"+"");
	}
	
	
	public boolean isPasswordEquls(){
		if(pPassword.getText().equals(pPasswordRe.getText()))
			return true;
		return false;
	}
	/*public boolean isIdEquls(){
		if(pID.getTfValue().equals(pID.getTfValue()))
			return true;
		return false;
	}*/
	
	public boolean isgradeEquls(){
		if(pGrade.getSelectedItem().equals("관리자")?true:false)
			return true;
		return false;
	}
	
	public void clear(){
		pID.setTfValue("");
		pPassword.setText("");
		pPasswordRe.setText("");
		pEmail.setTfValue("");
		pGrade.setSelectedItem(0);
	}
	public boolean isEmptyCheck(){
		boolean result = false;
		if(pID.getTfValue().equals("")){
			return true;
		}
		if(pPassword.getPassword().equals("")){
			return true;
		}
		if(pPasswordRe.getPassword().equals("")){
			return true;
		}
		if(pEmail.getTfValue().equals("")){
			return true;
		}
		return false;
	}



	
	

}
