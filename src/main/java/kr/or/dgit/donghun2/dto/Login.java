package kr.or.dgit.donghun2.dto;

public class Login {
	private String id;
	private String password;
	private String email;
	private String grade;
	private String passwordRe;
	
	
	public Login(String id, String password, String email, String grade, String passwordRe) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.grade = grade;
		this.passwordRe = passwordRe;
	}
	
	

	public Login(String id, String password, String email, String passwordRe) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.passwordRe = passwordRe;
	}

	

	public Login(String id, String password) {
		this.id = id;
		this.password = password;
	}



	public Login() {}

	public String getId() {
		return id;
	}

	public String getPasswordRe() {
		return passwordRe;
	}

	public void setPasswordRe(String passwordRe) {
		this.passwordRe = passwordRe;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return String.format("Login [id=%s, password=%s, email=%s, grade=%s]", id, password, email, grade);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	

	

	
}
