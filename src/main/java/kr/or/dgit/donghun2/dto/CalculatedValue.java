package kr.or.dgit.donghun2.dto;

public class CalculatedValue {
	private String scode;
	private int unitprice;
	private int sellprice;
	private int disprice;
	private int marginprice;
	private int marginpct;
	
	public CalculatedValue() {}
	
	
	
	public CalculatedValue(String scode, int unitprice, int sellprice, int disprice, int marginprice, int marginpct) {
		super();
		this.scode = scode;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
		this.marginprice = marginprice;
		this.marginpct = marginpct;
	}



	public CalculatedValue(int unitprice, int sellprice, int disprice, int marginprice, int marginpct) {
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
		this.marginprice = marginprice;
		this.marginpct = marginpct;
	}

	public String getScode() {
		return scode;
	}



	public void setScode(String scode) {
		this.scode = scode;
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
		return String.format(
				"CalculatedValue [scode=%s, unitprice=%s, sellprice=%s, disprice=%s, marginprice=%s, marginpct=%s]",
				scode, unitprice, sellprice, disprice, marginprice, marginpct);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scode == null) ? 0 : scode.hashCode());
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
		CalculatedValue other = (CalculatedValue) obj;
		if (scode == null) {
			if (other.scode != null)
				return false;
		} else if (!scode.equals(other.scode))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
