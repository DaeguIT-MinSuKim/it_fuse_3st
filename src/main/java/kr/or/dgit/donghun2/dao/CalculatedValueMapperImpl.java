package kr.or.dgit.donghun2.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.donghun2.dto.CalculatedValue;
import kr.or.dgit.donghun2.dto.Employee;

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
	public List<CalculatedValue> vw_InfoByCustomerByCode(Map<String, String> item) {
		return sqlSession.selectList(namespace+"vw_InfoByCustomerByCode", item);
	}

	@Override
	public List<CalculatedValue> vw_InfoByProductByCode(Map<String, String> item) {
		return sqlSession.selectList(namespace+"vw_InfoByProductByCode", item);
	}

	@Override
	public List<CalculatedValue> vw_InfoByEmployeeByCode(Map<String, String> item) {
		return sqlSession.selectList(namespace+"vw_InfoByEmployeeByCode", item);
	}

	@Override
	public List<CalculatedValue> selectCalculatedValueByEmployeeChart() {
		return sqlSession.selectList(namespace+"selectCalculatedValueByEmployeeChart");
	}

	@Override
	public List<CalculatedValue> selectCalculatedValueByProductChart() {
		return sqlSession.selectList(namespace+"selectCalculatedValueByProductChart");
	}

}
