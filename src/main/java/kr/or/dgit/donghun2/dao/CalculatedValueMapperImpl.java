package kr.or.dgit.donghun2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.CalculatedValue;

public class CalculatedValueMapperImpl implements CalculatedValueMapper {
	private String namespace="kr.or.dgit.donghun2.dao.CalculatedValueMapper.";
	
	private SqlSession sqlSession;
	public CalculatedValueMapperImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<CalculatedValue> selectCalculatedValueByAll() {
		return sqlSession.selectList(namespace+"selectCalculatedValueByAll");
	}

	@Override
	public CalculatedValue selectCalculatedValueByNo(CalculatedValue code) {
		return sqlSession.selectOne(namespace+"selectCalculatedValueByNo", code);
	}

}
