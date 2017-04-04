package kr.or.dgit.donghun2.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.CalculatedValueMapper;
import kr.or.dgit.donghun2.dao.CalculatedValueMapperImpl;
import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.SellInfo;
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
	
	public CalculatedValue selectCalculatedValueByNo(CalculatedValue code){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			CalculatedValueMapper calculatedValueMapper = new CalculatedValueMapperImpl(sqlSession);
			return calculatedValueMapper.selectCalculatedValueByNo(code);
		}
	}

	public List<CalculatedValue> vw_InfoByCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
