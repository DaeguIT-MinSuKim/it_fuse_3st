package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.Product;

public class ProductMapperImpl implements ProductMapper{
	private String namespace = "kr.or.dgit.donghun2.dao.ProductMapper.";
	
	private SqlSession sqlSession;
	public ProductMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	public List<Product> selectProductByAll() {
		return sqlSession.selectList(namespace+"selectProductByAll");
	}
	
	
	public int insertProduct(Product product) {
		return sqlSession.insert(namespace+"insertProduct",product);
	}
	
	public int deleteProduct(Product code) {
		return sqlSession.delete(namespace+"deleteProduct",code);
	}
	
	public int updateProduct(Product product) {
		return sqlSession.update(namespace+"updateProduct",product);
	}

	
	public Product selectProductByNo(Product code) {
		return sqlSession.selectOne(namespace+"selectProductByNo",code);
	}

	public Product selectProductByNoForSellInfo(Product code) {
		return sqlSession.selectOne(namespace+"selectProductByNoForSellInfo",code);
	}

	
}
