package kr.or.dgit.donghun2.dto;

import java.util.Date;

public class SellInfo {
	private Employee employee;
	private Customer customer;
	private Product product;
	private String scode;
	private Date saleDate;
	private int quantity;
	
	public SellInfo() {}
	
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
				"SaleInfo [employee=%s, customer=%s, product=%s, saleDate=%s, quantity=%s",
				employee, customer, product, saleDate, quantity);
	}

	
	
}