package kr.or.dgit.donghun2.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CalculatedValue {
	private String scode;
	private int unitprice;
	private int sellprice;
	private int disprice;
	private int marginprice;
	private int marginpct;
	private Employee employee;
	private Product product;
	private Customer customer;
	private SellInfo sellinfo;
	
	public CalculatedValue() {}
	
	
	
	public CalculatedValue(String scode, int unitprice, int sellprice, int disprice, int marginprice, int marginpct,
			Employee employee, Product product, Customer customer, SellInfo sellinfo) {
		this.scode = scode;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
		this.marginprice = marginprice;
		this.marginpct = marginpct;
		this.employee = employee;
		this.product = product;
		this.customer = customer;
		this.sellinfo = sellinfo;
	}



	public CalculatedValue(String scode, int unitprice, int sellprice, int disprice, int marginprice, int marginpct) {
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


	
	
	
	public CalculatedValue(String scode) {
		super();
		this.scode = scode;
	}

	

	
	





	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public SellInfo getSellinfo() {
		return sellinfo;
	}



	public void setSellinfo(SellInfo sellinfo) {
		this.sellinfo = sellinfo;
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
		return "CalculatedValue [scode=" + scode + ", unitprice=" + unitprice + ", sellprice=" + sellprice
				+ ", disprice=" + disprice + ", marginprice=" + marginprice + ", marginpct=" + marginpct + ", employee="
				+ employee + ", product=" + product + ", customer=" + customer + ", sellinfo=" + sellinfo + "]";
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



	

	public String[] toArrayforCustomerSellInfoT(){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return new String[] 
				{df.format(sellinfo.getSaleDate()),
							product.getCode(),
							product.getName(),
				 String.format("%,d",sellinfo.getQuantity()),
				 String.format("%,d",sellprice),
				 String.format("%,d",disprice),
				 String.format("%,d",marginprice),
				 String.format("%,d",marginpct)};
	}
	
	public String[] toArrayforProductSellInfoT(){
		return new String[] 
				{			customer.getCode(),
							customer.getName(),
				 String.format("%,d",sellinfo.getQuantity()),
				 String.format("%,d",sellprice),
				 String.format("%,d",disprice),
				 String.format("%,d",marginprice),
				 String.format("%,d",marginpct)};
	}
	
	public String[] toArrayforEmployeeSellInfoT(){
		return new String[] 
				{			employee.getCode(),
							employee.getName(),
				 String.format("%,d",sellprice),
				 String.format("%,d",marginprice),
				 String.format("%,d",marginpct)};
	}



	public String[] toArrayforEmployeeSellInfoByCodeT() {
		return new String[] 
				{			employee.getCode(),
							employee.getName(),
					//	"","",
				 String.format("%,d",sellprice),
				 String.format("%,d",marginprice),
				 String.format("%,d",marginpct)};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
