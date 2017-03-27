package kr.or.dgit.donghun2.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dao.SellInfoMapper;
import kr.or.dgit.donghun2.dao.SellInfoMapperImpl;
import kr.or.dgit.donghun2.dto.SellInfo;
import kr.or.dgit.donghun2.util.MybatisSqlSessionFactory;

public class SellInfoService {
	private static final Log log = LogFactory.getLog(SellInfoService.class);
	
	private static final SellInfoService instance = new SellInfoService();
	public static SellInfoService getInstance() {return instance;}
	
	public List<SellInfo> selectSellInfoByAll(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			SellInfoMapper sellInfoMapper = new SellInfoMapperImpl(sqlSession);
			return sellInfoMapper.selectSellInfoByAll();
		}
	}
	
	public int insertSellInfo(SellInfo sellInfo){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			SellInfoMapper sellInfoMapper = new SellInfoMapperImpl(sqlSession);
			int res = sellInfoMapper.insertSellInfo(sellInfo);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateSellInfo(SellInfo sellInfo){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			SellInfoMapper sellInfoMapper = new SellInfoMapperImpl(sqlSession);
			int res = sellInfoMapper.updateSellInfo(sellInfo);
			sqlSession.commit();
			return res;
		}
	}
	public int deleteSellInfo(SellInfo code){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			SellInfoMapper sellInfoMapper = new SellInfoMapperImpl(sqlSession);
			int res = sellInfoMapper.deleteSellInfo(code);
			sqlSession.commit();
			return res;
		}
	}
	
	public SellInfo selectSellInfoByNo(SellInfo code){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			SellInfoMapper sellInfoMapper = new SellInfoMapperImpl(sqlSession);
			return sellInfoMapper.selectSellInfoByNo(code);
		}
	}
	
	
}
