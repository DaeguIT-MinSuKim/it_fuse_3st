package kr.or.dgit.donghun2.dto;

public class Egrade {
	private String grade;
	private int dispct;
	private boolean isexist;
	
	public Egrade() {	}
	public Egrade(String grade, int dispct, boolean isexist) {
		this.grade = grade;
		this.dispct = dispct;
		this.isexist = isexist;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getDispct() {
		return dispct;
	}
	public void setDispct(int dispct) {
		this.dispct = dispct;
	}
	public boolean isIsexist() {
		return isexist;
	}
	public void setIsexist(boolean isexist) {
		this.isexist = isexist;
	}
	@Override
	public String toString() {
		return "Egrade [grade=" + grade + ", dispct=" + dispct + ", isexist=" + isexist + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
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
		Egrade other = (Egrade) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}
	

	
	
}
