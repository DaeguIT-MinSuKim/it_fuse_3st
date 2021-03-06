package kr.or.dgit.donghun2.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.CalculatedValueMapper;
import kr.or.dgit.donghun2.dao.CalculatedValueMapperImpl;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class CalculatedValueService {
	private static final Log log = LogFactory.getLog(CalculatedValueService.class);
	
	private static final CalculatedValueService instance = new CalculatedValueService();
	public static CalculatedValueService getInstance() {return instance;}
	
	public List<CalculatedValue> selectCalculatedValueByAll(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.selectCalculatedValueByAll();
		}
	}
	
	public CalculatedValue selectCalculatedValueByNo(CalculatedValue scode){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.selectCalculatedValueByNo(scode);
		}
	}

	
	
	public List<CalculatedValue> vw_InfoByCustomer(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.vw_InfoByCustomer();
		}
	}
	
	public List<CalculatedValue> vw_InfoByProduct(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.vw_InfoByProduct();
		}
	}
	
	public List<CalculatedValue> vw_InfoByEmployee(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.vw_InfoByEmployee();
		}
	}
	
	public List<CalculatedValue> vw_InfoByCustomerByCode(Map<String, String> item){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.vw_InfoByCustomerByCode(item);
		}
	}
	
	public List<CalculatedValue> vw_InfoByProductByCode(Map<String, String> item){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.vw_InfoByProductByCode(item);
		}
	}
	
	public List<CalculatedValue> vw_InfoByEmployeeByCode(Map<String, String> item){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.vw_InfoByEmployeeByCode(item);
		}
	}
	public List<CalculatedValue> selectCalculatedValueByEmployeeChart(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.selectCalculatedValueByEmployeeChart();
		}
	}
	public List<CalculatedValue> selectCalculatedValueByProductChart(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.selectCalculatedValueByProductChart();
		}
	}
	public List<CalculatedValue> selectCalculatedValueByCustomerChart(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.selectCalculatedValueByCustomerChart();
		}
	}
}
