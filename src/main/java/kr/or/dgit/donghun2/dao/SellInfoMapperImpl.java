package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.SellInfo;

public class SellInfoMapperImpl implements SellInfoMapper {
	private String namespace = "kr.or.dgit.donghun2.dao.SellInfoMapper.";
	
	private SqlSession sqlSession;
	public SellInfoMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int updateSellInfo(SellInfo sellInfo) {
		return sqlSession.update(namespace+"updateSellInfo", sellInfo);
	}

	@Override
	public int insertSellInfo(SellInfo sellInfo) {
		return sqlSession.insert(namespace+"insertSellInfo", sellInfo);
	}

	@Override
	public List<SellInfo> selectSellInfoByAll() {
		return sqlSession.selectList(namespace+"selectSellInfoByAll");
	}

	@Override
	public SellInfo selectSellInfoByNo(SellInfo code) {
		return sqlSession.selectOne(namespace+"selectSellInfoByNo");
	}

	@Override
	public int deleteSellInfo(SellInfo code) {
		return sqlSession.delete(namespace+"deleteSellInfo");
	}


}
