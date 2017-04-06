package kr.or.dgit.donghun2.dto;

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
	
	public SellInfo( String ecode, String pcode, String ccode, String scode,Date saledate , int quantity, int saleprice,
			int origiprice, int dispcts) {
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

	///////
	public SellInfo(String scode, String pcode, int quantity, Date saledate) {
		super();
		this.scode = scode;
		this.pcode = pcode;
		this.quantity = quantity;
		this.saledate = saledate;
	}
	////////
	
	public SellInfo(String scode2, String ecodeResult, String pCodeResult, String ccodeResult, int quantity2,
			Date saleDate2, int saleprice2, int origiprice2, int fulldispcts) {
		this.scode = scode2;
		this.ecode = ecodeResult;
		this.pcode = pCodeResult;
		this.ccode = ccodeResult;
		this.quantity = quantity2;
		this.saledate = saleDate2;
		this.saleprice = saleprice2;
		this.origiprice = origiprice2;
		this.dispcts = fulldispcts;
		this.isexist = isexist;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	
	
	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
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

	




	
	
}