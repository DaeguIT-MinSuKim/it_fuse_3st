package kr.or.dgit.donghun2.dto;

public class Login {
	private String id;
	private String password;
	private String passwordRe;
	private String email;

	public Login() {
	}

	public Login(String id, String password) {
		this.id = id;
		this.password = password;
	}
	

	public Login(String id, String password, String email) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public Login(String id, String password, String passwordRe, String email) {
		this.id = id;
		this.password = password;
		this.passwordRe = passwordRe;
		this.email = email;
	}
	
	public Login(String id) {
		super();
		this.id = id;
	}

	public String getPasswordRe() {
		return passwordRe;
	}

	public void setPasswordRe(String passwordRe) {
		this.passwordRe = passwordRe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%s", id, password, email);
	}
	
}
