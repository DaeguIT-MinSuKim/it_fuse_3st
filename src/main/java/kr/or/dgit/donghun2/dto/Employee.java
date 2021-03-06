package kr.or.dgit.donghun2.dto;

public class Employee {
	private String code;
	private String name;
	private String grade;	
	private Egrade eGrade;
	private boolean isexist;


	public Employee() {}

	public Employee(String code, String name, String grade) {
		this.code = code;
		this.name = name;
		this.grade = grade;
	}
	
	
	
	public Employee(String code) {
		super();
		this.code = code;
	}

	
	
	public Egrade geteGrade() {
		return eGrade;
	}

	public void seteGrade(Egrade eGrade) {
		this.eGrade = eGrade;
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


	@Override
	public String toString() {
		if(isexist==false){
			return code == null ? "전체보기" : code+"( "+name+" / "+grade+" ) " +"("+"퇴사"+")";
		}
		return code == null ? "전체보기" : code+"( "+name+" / "+grade+" ) " +"("+"입사"+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String[] toArray() {
		return new String[] {code, name, grade};
	}

}
