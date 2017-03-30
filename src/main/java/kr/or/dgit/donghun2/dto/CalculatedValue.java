package kr.or.dgit.donghun2.dto;

public class CalculatedValue {
	private int unitprice;
	private int sellprice;
	private int disprice;
	private int marginprice;
	private int marginpct;
	
	public CalculatedValue() {}
	
	public CalculatedValue(int unitprice, int sellprice, int disprice, int marginprice, int marginpct) {
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
		this.marginprice = marginprice;
		this.marginpct = marginpct;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public int getDisprice() {
		return disprice;
	}

	public void setDisprice(int disprice) {
		this.disprice = disprice;
	}

	public int getMarginprice() {
		return marginprice;
	}

	public void setMarginprice(int marginprice) {
		this.marginprice = marginprice;
	}

	public int getMarginpct() {
		return marginpct;
	}

	public void setMarginpct(int marginpct) {
		this.marginpct = marginpct;
	}
	
	
	@Override
	public String toString() {
		return String.format("[%s,%s,%s,%s,%s]",unitprice, sellprice, disprice, marginprice, marginpct);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
