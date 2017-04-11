package kr.or.dgit.donghun2.dao;

import java.util.List;

import kr.or.dgit.donghun2.dto.Product;

public interface ProductMapper{


	public List<Product> selectProductByAll();
	
	public int insertProduct(Product product);
	
	public int deleteProduct(Product code);
	
	public int updateProduct(Product product);

	public Product selectProductByNo(Product code);

	public Product selectProductByNoForSellInfo(Product code);

	public List<Product> selectProductByAllDesc();
}
