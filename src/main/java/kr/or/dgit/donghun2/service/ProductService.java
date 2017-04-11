package kr.or.dgit.donghun2.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.ProductMapper;
import kr.or.dgit.donghun2.dao.ProductMapperImpl;
import kr.or.dgit.donghun2.dto.Product;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class ProductService {
	private static final Log log = LogFactory.getLog(ProductService.class);

	private static final ProductService instance = new ProductService();
	public static ProductService getInstance() {return instance;};
	
	
	public List<Product> selectProductByAll(){
		log.debug("selectProductByAll()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			return productMapper.selectProductByAll();
		}
	}

	public int insertProduct(Product product){
		log.debug("insertProduct()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			int res = productMapper.insertProduct(product);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateProduct(Product product){
		log.debug("updateProduct()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			int res = productMapper.updateProduct(product);
			sqlSession.commit();
			return res;
		}
	}
	public int deleteProduct(Product code){
		log.debug("updateProduct()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			int res = productMapper.deleteProduct(code);
			sqlSession.commit();
			return res;
		}
	}
	
	public Product selectProductByNo(Product code){
		log.debug("selectProductByNo()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			return productMapper.selectProductByNo(code);
		}
	}
	public Product selectProductByNoForSellInfo(Product code){
		log.debug("selectProductByNoForSellInfo()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			return productMapper.selectProductByNoForSellInfo(code);
		}
	}
	public List<Product> selectProductByAllDesc(){
		log.debug("selectProductByAllDesc()");
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			ProductMapper productMapper = new ProductMapperImpl(sqlSession);
			return productMapper.selectProductByAllDesc();
		}
	}
}
