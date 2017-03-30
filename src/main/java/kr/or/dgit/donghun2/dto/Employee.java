package kr.or.dgit.donghun2.dto;

public class Employee {
	private String code;
	private String name;
	private String grade;
<<<<<<< HEAD
	
	boolean isexist;
=======
	private boolean isexist;
>>>>>>> refs/remotes/origin/master

	public Employee() {}

	public Employee(String code, String name, String grade) {
		this.code = code;
		this.name = name;
		this.grade = grade;
	}
	
	
	
	public boolean isIsexist() {
		return isexist;
	}

	public void setIsexist(boolean isexist) {
		this.isexist = isexist;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Employee(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Employee(String code, String name, String grade, boolean isexist) {
		super();
		this.code = code;
		this.name = name;
		this.grade = grade;
		this.isexist = isexist;
	}

<<<<<<< HEAD
	public String[] toArray() {
		return new String[]{code,name,grade};
	}
=======
>>>>>>> refs/remotes/origin/master

}
