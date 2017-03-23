package kr.or.dgit.donghun2.dto;

import java.util.Date;

public class SellInfo {
	private Employee employee;
	private Customer customer;
	private Product product;
	private Date saleDate;
	private int quantity;
	private int unitprice;
	private int sellprice;
	private int disprice;
	
	public SellInfo() {}
	
	public SellInfo(Date saleDate, int quantity) {
		this.saleDate = saleDate;
		this.quantity = quantity;
	}
	
	public SellInfo(int unitprice, int sellprice, int disprice) {
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
	}

	public SellInfo(Date saleDate, int quantity, int unitprice, int sellprice, int disprice) {
		this.saleDate = saleDate;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
	}

	public SellInfo(Employee employee, Customer customer, Product product, Date saleDate, int quantity, int unitprice,
			int sellprice, int disprice) {
		super();
		this.employee = employee;
		this.customer = customer;
		this.product = product;
		this.saleDate = saleDate;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
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

	public int getUnitprice() {
		return unitprice;
	}

	public int getSellprice() {
		return sellprice;
	}

	public int getDisprice() {
		return disprice;
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

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public void setDisprice(int disprice) {
		this.disprice = disprice;
	}

	@Override
	public String toString() {
		return String.format(
				"SaleInfo [employee=%s, customer=%s, product=%s, saleDate=%s, quantity=%s, unitprice=%s, sellprice=%s, disprice=%s]",
				employee, customer, product, saleDate, quantity, unitprice, sellprice, disprice);
	}
	
	
}