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
	
	
	
}
