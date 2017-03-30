package kr.or.dgit.donghun2.dto;

import java.util.Date;

public class SellInfo {
	private Employee employee;
	private Customer customer;
	private Product product;
	private String scode;
	private Date saleDate;
	private int quantity;
<<<<<<< HEAD
=======
	private int saleprice;
	private int origiprice;
	private boolean isexist;
	private SellInfoDetail sellInfoDetail;
>>>>>>> refs/remotes/origin/master
	
	public SellInfo() {}
	
	
	
	public SellInfo(String scode, Date saleDate, int quantity, int saleprice, int origiprice) {
		this.scode = scode;
		this.saleDate = saleDate;
		this.quantity = quantity;
		this.saleprice = saleprice;
		this.origiprice = origiprice;
	}



	public SellInfo(String scode, Date saleDate, int quantity, int saleprice, int origiprice, boolean isexist) {
		this.scode = scode;
		this.saleDate = saleDate;
		this.quantity = quantity;
		this.saleprice = saleprice;
		this.origiprice = origiprice;
		this.isexist = isexist;
	}



	public SellInfo(Date saleDate, int quantity) {
		this.saleDate = saleDate;
		this.quantity = quantity;
	}

	public SellInfo(Employee employee, Customer customer, Product product, Date saleDate, int quantity, int unitprice,
			int sellprice, int disprice) {
		this.employee = employee;
		this.customer = customer;
		this.product = product;
		this.saleDate = saleDate;
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

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Product getProduct() {
		return product;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format(
				"SellInfo [employee=%s, customer=%s, product=%s, scode=%s, saleDate=%s, quantity=%s, saleprice=%s, origiprice=%s, isexist=%s]",
				employee, customer, product, scode, saleDate, quantity, saleprice, origiprice, isexist);
	}


	
	
}