package kr.or.dgit.donghun2.dto;


public class SellInfoDetail {
	private String scode;
	private int unitprice;
	private int sellprice;
	private int disprice;
	private int marginPrice;
	private int marginPct;
	
	public SellInfoDetail() {
	}
	public SellInfoDetail(String scode, int unitprice, int sellprice, int disprice) {
		this.scode = scode;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
	}
	public SellInfoDetail(String scode, int unitprice, int sellprice, int disprice, int marginPrice, int marginPct) {
		this.scode = scode;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
		this.marginPrice = marginPrice;
		this.marginPct = marginPct;
	}
	public SellInfoDetail(int unitPrice, int sellPrice, int disPrice) {
		this.unitprice = unitPrice;
		this.sellprice = sellPrice;
		this.disprice = disPrice;
	}
	public SellInfoDetail(int unitprice, int sellprice, int disprice, int marginPrice, int marginPct) {
		super();
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
		this.marginPrice = marginPrice;
		this.marginPct = marginPct;
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
	public int getMarginPrice() {
		return marginPrice;
	}
	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}
	public int getMarginPct() {
		return marginPct;
	}
	public void setMarginPct(int marginPct) {
		this.marginPct = marginPct;
	}
	@Override
	public String toString() {
		return String.format(
				"SellInfoDetail [scode=%s, unitprice=%s, sellprice=%s, disprice=%s, marginPrice=%s, marginPct=%s]",
				scode, unitprice, sellprice, disprice, marginPrice, marginPct);
	}
	

	
	
}