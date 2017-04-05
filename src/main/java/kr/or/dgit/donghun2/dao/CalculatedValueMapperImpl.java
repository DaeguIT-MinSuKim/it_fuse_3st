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
	public CalculatedValue selectCalculatedValueByNo(CalculatedValue scode) {
		return sqlSession.selectOne(namespace+"selectCalculatedValueByNo", scode);
	}

	@Override
	public List<CalculatedValue> vw_InfoByCustomer() {
		return sqlSession.selectList(namespace+"vw_InfoByCustomer");
	}

	@Override
	public List<CalculatedValue> vw_InfoByProduct() {
		return sqlSession.selectList(namespace+"vw_InfoByProduct");
	}

	@Override
	public List<CalculatedValue> vw_InfoByEmployee() {
		return sqlSession.selectList(namespace+"vw_InfoByEmployee");
	}

	@Override
	public CalculatedValue vw_InfoByCustomerByCode(CalculatedValue ccode) {
		return sqlSession.selectOne(namespace+"vw_InfoByCustomerByCode", ccode);
	}

	@Override
	public CalculatedValue vw_InfoByProductByCode(CalculatedValue pcode) {
		return sqlSession.selectOne(namespace+"vw_InfoByProductByCode", pcode);
	}

	@Override
	public CalculatedValue vw_InfoByEmployeeByCode(CalculatedValue ecode) {
		return sqlSession.selectOne(namespace+"vw_InfoByEmployeeByCode", ecode);
	}

}
