package kr.or.dgit.donghun2.dto;

public class Product {
	private String code;
	private String name;
	private int salePrice;
	private int origiPrice;
	private boolean isexist;
	
	public Product() {}

	public Product(String code, String name, int salePrice, int origiPrice) {
		this.code = code;
		this.name = name;
		this.salePrice = salePrice;
		this.origiPrice = origiPrice;
	}
	
	

	public Product(String code, String name, int salePrice) {
		this.code = code;
		this.name = name;
		this.salePrice = salePrice;
	}



	public Product(String code, String name) {
		this.code = code;
		this.name = name;
	}



	public Product(String code) {
		this.code = code;
	}

	public boolean isIsexist() {
		return isexist;
	}



	public void setIsexist(boolean isexist) {
		this.isexist = isexist;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getOrigiPrice() {
		return origiPrice;
	}

	public void setOrigiPrice(int origiPrice) {
		this.origiPrice = origiPrice;
	}




	public Product(String code, String name, int salePrice, int origiPrice, boolean isexist) {
		super();
		this.code = code;
		this.name = name;
		this.salePrice = salePrice;
		this.origiPrice = origiPrice;
		this.isexist = isexist;
	}
	
	@Override
	public String toString() {
		return "제품코드 : "+code+"( 제품명  : " + name + " / 판매정가  : " + String.format("%,d",salePrice)+" )";
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	public String[] toArray() {
		return new String[] {code, name, String.format("%,d",salePrice), String.format("%,d",origiPrice)};
	}
	
	
}
