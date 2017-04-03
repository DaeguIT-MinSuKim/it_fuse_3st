package kr.or.dgit.donghun2.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SellInfo {
	private String scode;
	private String ecode;
	private String pcode;
	private String ccode;
	private int quantity;
	private Date saledate;
	
	private int saleprice;
	private int origiprice;
	private int dispcts;
	private boolean isexist;
	
	public SellInfo() {}
	
	public SellInfo(String scode, Date saledate, int quantity) {
		this.scode = scode;
		this.saledate = saledate;
		this.quantity = quantity;
	}

	public SellInfo(String scode, String ecode, String pcode, String ccode, int quantity, Date saledate, int saleprice,
			int origiprice, int dispcts, boolean isexist) {
		super();
		this.scode = scode;
		this.ecode = ecode;
		this.pcode = pcode;
		this.ccode = ccode;
		this.quantity = quantity;
		this.saledate = saledate;
		this.saleprice = saleprice;
		this.origiprice = origiprice;
		this.dispcts = dispcts;
		this.isexist = isexist;
	}




	public SellInfo(String scode, Date saleDate, int quantity, int saleprice, int origiprice, int dispcts,
			boolean isexist) {
		super();
		this.scode = scode;
		this.saledate = saleDate;
		this.quantity = quantity;
		this.saleprice = saleprice;
		this.origiprice = origiprice;
		this.setDispcts(dispcts);
		this.isexist = isexist;
	}



	public SellInfo(String scode, Date saleDate, int quantity, int saleprice, int origiprice) {
		this.scode = scode;
		this.saledate = saleDate;
		this.quantity = quantity;
		this.saleprice = saleprice;
		this.origiprice = origiprice;
	}



	public SellInfo(String scode, Date saleDate, int quantity, int saleprice, int origiprice, boolean isexist) {
		this.scode = scode;
		this.saledate = saleDate;
		this.quantity = quantity;
		this.saleprice = saleprice;
		this.origiprice = origiprice;
		this.isexist = isexist;
	}

	

	public SellInfo(Date saleDate, int quantity) {
		this.saledate = saleDate;
		this.quantity = quantity;
	}




	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public Date getSaleDate() {
		return saledate;
	}

	public void setSaleDate(Date saleDate) {
		this.saledate = saleDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getOrigiprice() {
		return origiprice;
	}

	public void setOrigiprice(int origiprice) {
		this.origiprice = origiprice;
	}

	public boolean isIsexist() {
		return isexist;
	}

	public void setIsexist(boolean isexist) {
		this.isexist = isexist;
	}

	public int getDispcts() {
		return dispcts;
	}

	public void setDispcts(int dispcts) {
		this.dispcts = dispcts;
	}



	@Override
	public String toString() {
		return String.format(
				"SellInfo [ecode=%s, pcode=%s, ccode=%s, scode=%s, saleDate=%s, quantity=%s, saleprice=%s, origiprice=%s, dispcts=%s, isexist=%s]",
				ecode, pcode, ccode, scode, saledate, quantity, saleprice, origiprice, dispcts, isexist);
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
		SellInfo other = (SellInfo) obj;
		if (scode == null) {
			if (other.scode != null)
				return false;
		} else if (!scode.equals(other.scode))
			return false;
		return true;
	}


	


	
	
}